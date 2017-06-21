package world.elements.entity;

import engine.Context;
import engine.Engine;
import world.IComponent;
import world.IEntity;
import world.Permeability;
import world.Position;
import world.behavior.IDisplacementBehavior;
import world.elements.Elements;

import java.awt.*;
import java.util.Optional;

public abstract class Entity extends Elements implements IEntity, IDisplacementBehavior {
    protected StateManager stateManager;

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
                return this.getContext(this.getProjection(0, 1));
            case DOWN:
                return this.getContext(this.getProjection(0, -1));
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
}
