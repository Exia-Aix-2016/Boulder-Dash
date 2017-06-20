package world.elements.entity;

import engine.Engine;
import engine.TickListener;
import world.Permeability;
import world.Position;
import world.elements.Elements;

import java.awt.*;
import java.util.Optional;

public abstract class Entity extends Elements implements TickListener, IContact{

    public State state;
    public Engine engine;

    Entity(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
        state = new State();
    }

    private Optional<IContact> getForwardElement(){

        // TODO
        switch (this.state.getStateType()){
            case UP:
                break;
            case DOWN:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
            case WAITING:
                break;
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
