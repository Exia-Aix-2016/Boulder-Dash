package world.elements;

import world.Dimension;
import world.Position;

public class Wall extends Element {

    Wall(final String sprite, Position position, final Dimension dimension, Permeability permeability) {
        super(sprite, position, dimension, permeability);
    }
}
