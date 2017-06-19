package world.elements.entity;

import world.Dimension;
import world.Permeability;
import world.Position;
import world.elements.Elements;

public abstract class Entity extends Elements{
       Entity(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, permeability);
    }

}
