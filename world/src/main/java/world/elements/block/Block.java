package world.elements.block;

import world.Position;
import world.elements.Elements;
import world.elements.SpriteManager;

import java.awt.*;

/**
 * Block Element
 * @see Elements
 * */
public abstract class Block extends Elements {

    public Block(Position position, Dimension dimension, SpriteManager spriteManager) {
        super(position, dimension, spriteManager);
    }

    @Override
    public void destroy() {
        this.engine.removeBlock(this);
    }
}
