package world.elements;

import world.Dimension;
import world.Position;

public class Rock extends Movable {
    Rock(final String sprite, Position position, final Dimension dimension, Permeability permeability) {
        super(sprite, position, dimension, permeability);
    }
}
