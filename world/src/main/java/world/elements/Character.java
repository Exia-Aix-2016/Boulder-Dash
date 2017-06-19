package world.elements;

import world.Dimension;
import world.Position;

public class Character extends Movable{

    Character(final String sprite, Position position, final Dimension dimension, Permeability permeability) {
        super(sprite, position, dimension, permeability);
    }

}
