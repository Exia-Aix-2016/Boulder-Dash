package world.elements.entity;

import engine.Context;
import world.IComponent;
import world.IEntity;
import world.Position;
import world.behavior.Behavior;
import world.elements.Elements;
import world.elements.IAction;
import world.elements.SpriteManager;
import world.reaction.Sides;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Entity is a element in mouvement on the map
 * @see Elements
 * */
public abstract class Entity extends Elements implements IEntity, IMovement {

    protected Thread thread = null;

    protected StateManager stateManager;
    protected Collection<Behavior> behaviors = new ArrayList<>();

    protected Rectangle futureBounds = null;

    protected  boolean behaviorIgnored = false;

    Entity(Position position, Dimension dimension, SpriteManager spriteManager, int speed){
        super(position, dimension, spriteManager);
         stateManager = new StateManager(speed);
         stateManager.pushState(StateType.WAITING);
    }

    public Optional<IAction> getContext(Rectangle rec){
        Context context = this.engine.getContext(rec);

        Optional<IComponent> component = context.get();

        if (component.isPresent()){
            return Optional.of((IAction) component.get());
        }

        return Optional.empty();
    }

    protected Optional<IAction> getForwardElement(){

        if (this.getForwardProjection() != null){
            return this.getContext(this.getForwardProjection());
        }

        return Optional.empty();
    }

    protected Rectangle getForwardProjection(){
        switch (this.stateManager.getCurrentState().getStateType()){
            case UP:
                return this.getProjection(0, -1);
            case DOWN:
                return this.getProjection(0, 1);
            case LEFT:
                return this.getProjection(-1, 0);
            case RIGHT:
                return this.getProjection(1, 0);
        }
        return null;
    }

    public Rectangle getProjection(int xCase, int yCase){

        Rectangle center = this.getBounds();

        Rectangle rec = new Rectangle(
                center.x + xCase * center.width,
                center.y + yCase * center.height,
                center.width,
                center.height
        );

        return rec;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public Sides getReactionSide(){
        switch (this.stateManager.getCurrentState().getStateType()){

            case UP:
                return Sides.BOTTOM;
            case DOWN:
                return Sides.TOP;
            case LEFT:
                return Sides.RIGHT;
            case RIGHT:
                return Sides.LEFT;
        }
        return null;
    }

    public boolean isMapBorder(){
        if (this.getForwardProjection() != null){
            return this.engine.isOut(this.getForwardProjection());
        }
        return false;
    }

    public void run(){

        if (!this.stateManager.getCurrentState().isMoving()){

            if (!this.behaviorIgnored){
                this.executeBehaviors();
            } else {
                this.behaviorIgnored = false;
            }

            if (this.stateManager.getCurrentState().getStateType() != StateType.WAITING){
                Optional<IAction> forwardEl = this.getForwardElement();
                boolean move = false;

                if (forwardEl.isPresent()){
                    IAction el = forwardEl.get();
                    if (el.isReaction(this, this.getReactionSide())){
                        move = el.performReaction(this, this.getReactionSide(), this.stateManager.getCurrentState().getTicks());
                    } else {
                        this.stateManager.setBlockState(true);
                    }
                } else {
                    if (this.isMapBorder()){
                        this.stateManager.setBlockState(true);
                    } else {
                        this.stateManager.setBlockState(false);
                        this.stateManager.setDefaultSpeed();
                        move = true;
                    }
                }

                if (move){
                    this.stateManager.getCurrentState().setMoving(true);
                    switch (this.stateManager.getCurrentState().getStateType()){
                        case UP:
                            this.futureBounds = this.getProjection(0, -1);
                            break;
                        case DOWN:
                            this.futureBounds = this.getProjection(0, 1);
                            break;
                        case LEFT:
                            this.futureBounds = this.getProjection(-1, 0);
                            break;
                        case RIGHT:
                            this.futureBounds = this.getProjection(1, 0);
                            break;
                    }
                }
            }
        }

        if (this.stateManager.getCurrentState().isMoving()){
            this.move();
        }

        this.stateManager.tickStateManager();
        this.setImage(this.spriteManager.getImage(this.stateManager.getCurrentState().getStateType()));
    }

    protected void move(){

        State currentState = this.stateManager.getCurrentState();

        int x = this.position.getX();
        int y = this.position.getY();

        switch (currentState.getStateType()){
            case UP:
                y -= currentState.getSpeed();
                break;
            case DOWN:
                y += currentState.getSpeed();
                break;
            case LEFT:
                x -= currentState.getSpeed();
                break;
            case RIGHT:
                x += currentState.getSpeed();
                break;
        }

        this.setPosition(this.calculateFuture(x, y));

        if (this.getBounds().getX() == this.futureBounds.getX() && this.getBounds().getY() == this.futureBounds.getY()){
            currentState.setMoving(false);
        }

    }

    protected Position calculateFuture(int x, int y){

        if (Math.abs(this.futureBounds.getY() - y) > 0){
            y = (int) this.futureBounds.getY();
        }

        if (Math.abs(this.futureBounds.getX() - x) > 0){
            x = (int) this.futureBounds.getX();
        }

        return new Position(x, y);
    }

    protected void executeBehaviors(){
        for (Behavior behavior: behaviors){
            behavior.execute();
        }
    }

    @Override
    public void ignoreBehavior() {
        this.behaviorIgnored = true;
    }

    @Override
    public void tick() {
        if (this.thread == null) {
            this.thread = new Thread(this);
        }
        if (!this.thread.isAlive()) {
            this.thread = new Thread(this);
            this.thread.start();
        }
    }

    @Override
    public boolean isEmpty(int xCase, int yCase) {
        if (!this.getContext(this.getProjection(xCase, yCase)).isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public void goUp() {
        this.stateManager.pushState(StateType.UP);
    }

    @Override
    public void goDown() {
        this.stateManager.pushState(StateType.DOWN);

    }

    @Override
    public void goLeft() {
        this.stateManager.pushState(StateType.LEFT);

    }

    @Override
    public void goRight() {
        this.stateManager.pushState(StateType.RIGHT);
    }

    @Override
    public void goRest() {
        this.stateManager.pushState(StateType.WAITING);
    }

    @Override
    public void destroy() {
        this.engine.removeEntity(this);
    }

    @Override
    public boolean hasFinish() {
        return false;
    }
}
