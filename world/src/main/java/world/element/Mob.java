package world.element;

import world.Dimension;
import world.Position;

public class Mob extends Movable{

    Mob(final String sprite, Position position, final Dimension dimension, Permeability permeability) {
        super(sprite, position, dimension, permeability);
    }
}
