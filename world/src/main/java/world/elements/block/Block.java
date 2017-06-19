package world.elements.block;

import world.Dimension;
import world.Position;
import world.Permeability;
import world.elements.Elements;

public abstract class Block extends Elements {



    public Block(Position position, Dimension dimension, final String sprite, Permeability permeability) {
        super(position, dimension, sprite, permeability);
    }
}
