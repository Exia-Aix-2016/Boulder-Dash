package world.elements.entity;

import engine.Engine;
import engine.TickListener;
import world.Permeability;
import world.Position;
import world.elements.Elements;

import java.awt.*;

public abstract class Entity extends Elements implements TickListener{

    public State state;
    public Engine engine;

    Entity(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
        state = new State();
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }


}
