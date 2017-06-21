package world.elements.block;

import world.Position;
import world.Permeability;
import world.elements.Elements;

import java.awt.*;

public abstract class Block extends Elements {

    public Block(Position position, Dimension dimension, final String sprite, Permeability permeability) {
        super(position, dimension, sprite, permeability);
    }

    @Override
    public void destroy() {
        this.engine.removeBlock(this);
    }
}
