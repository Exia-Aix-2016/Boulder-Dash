package world.elements.entity;

import engine.Context;
import world.IComponent;
import world.IEntity;
import world.Permeability;
import world.Position;
import world.behavior.Behavior;
import world.elements.Elements;
import world.elements.IAction;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public abstract class Entity extends Elements implements IEntity, IMovement {

    protected Thread thread = null;

    protected StateManager stateManager;
    protected Collection<Behavior> behaviors = new ArrayList<>();

    Entity(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
         stateManager = new StateManager();
         stateManager.pushState(StateType.WAITING);
    }

    protected Optional<IAction> getContext(Rectangle rec){
        Context context = this.engine.getContext(rec);

        Optional<IComponent> component = context.get();

        if (component.isPresent()){
            return Optional.of((IAction) component.get());
        }

        return Optional.empty();
    }

    protected Optional<IAction> getForwardElement(){

        switch (this.stateManager.getCurrentState().getStateType()){
            case UP:
                return this.getContext(this.getProjection(0, -1));
            case DOWN:
                return this.getContext(this.getProjection(0, 1));
            case LEFT:
                return this.getContext(this.getProjection(-1, 0));
            case RIGHT:
                return this.getContext(this.getProjection(1, 0));
        }

        return Optional.empty();
    }

    protected Rectangle getProjection(int xCase, int yCase){

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

    public void run(){
        State currentState = this.stateManager.getCurrentState();
        if (!currentState.isMoving()){
            this.executeBehaviors();
        }
        if (currentState.getStateType() != StateType.WAITING){
            Optional<IAction> forwardEl = this.getForwardElement();
            if (forwardEl.isPresent()){
                IAction el = forwardEl.get();
                if (el.isReaction(this)){
                    el.performReaction(this, currentState.getTicks());
                } else {
                    this.stateManager.setBlockState(true);
                }
            } else {
                this.stateManager.setBlockState(false);
            }
        }
        this.stateManager.tickStateManager();
    }

    protected void executeBehaviors(){
        for (Behavior behavior: behaviors){
            behavior.execute();
        }
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
}
