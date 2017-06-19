package world.elements.entity;

import world.Dimension;
import world.Position;
import world.Permeability;

public class Character extends Entity {


    public Character(Position position, Dimension dimension, String waiting_sprite, Permeability permeability) {
        super(position, dimension, waiting_sprite, permeability);
    }
}