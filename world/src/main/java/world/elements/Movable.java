package world.elements;

import world.Dimension;
import world.Position;

public abstract class Movable extends Element implements IMove{

    Movable(final String sprite, Position position, final Dimension dimension, Permeability permeability){
        super(sprite, position, dimension, permeability);
    }
}
