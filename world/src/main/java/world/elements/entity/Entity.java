package world.elements.entity;

import engine.Context;
import engine.Engine;
import engine.IEngine;
import engine.TickListener;
import world.IControllable;
import world.Permeability;
import world.Position;
import world.elements.Elements;
import world.elements.IContact;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public abstract class Entity extends Elements implements TickListener, IEngine {
    protected Engine engine;
    protected StateManager stateManager;

    Entity(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
         stateManager = new StateManager();


    }

    protected Optional<IContact> getContext(Rectangle rec){
        Context context = this.engine.getContext(rec);

        Optional<JComponent> component = context.get();

        if (component.isPresent()){
            return Optional.of((IContact) component.get());
        }

        return Optional.empty();
    }

    protected Optional<IContact> getForwardElement(){

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

    public void setEngine(Engine engine) {
        this.engine = engine;
    }


}
