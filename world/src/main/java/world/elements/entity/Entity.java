package world.elements.entity;

import world.Permeability;
import world.Position;
import world.elements.Elements;

import java.awt.*;

public abstract class Entity extends Elements{

    public State state;

    Entity(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
        state = new State();
    }

}
