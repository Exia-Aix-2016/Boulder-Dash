package world.elements.entity;

import engine.TickListener;
import world.Permeability;
import world.Position;
import world.elements.Elements;

import java.awt.*;

public abstract class Entity extends Elements implements TickListener{

    Entity(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
    }

}
