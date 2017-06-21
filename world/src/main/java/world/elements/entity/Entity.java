package world.elements.entity;

import engine.Context;
import world.IComponent;
import world.IEntity;
import world.Permeability;
import world.Position;
import world.behavior.IBehavior;
import world.behavior.IBehaviorControl;
import world.elements.Elements;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public abstract class Entity extends Elements implements IEntity, IBehavior {

    protected StateManager stateManager;
    protected Collection<IBehaviorControl> behaviors = new ArrayList<>();

    Entity(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
         stateManager = new StateManager();
    }

    protected Optional<IComponent> getContext(Rectangle rec){
        Context context = this.engine.getContext(rec);

        Optional<IComponent> component = context.get();

        if (component.isPresent()){
            return Optional.of(component.get());
        }

        return Optional.empty();
    }

    protected Optional<IComponent> getForwardElement(){

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

    @Override
    public StateManager getStateManager() {
        return stateManager;
    }

    @Override
    public void run() {

    }
}
