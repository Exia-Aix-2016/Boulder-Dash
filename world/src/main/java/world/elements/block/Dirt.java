package world.elements.block;

import world.Position;
import world.elements.SpriteManager;
import world.elements.entity.Character;
import world.reaction.Remove;
import world.reaction.Sides;

import java.awt.*;

/**
 * Dirt Element
 * @see Block
 * */
public class Dirt extends Block{

    public Dirt(Position position, Dimension dimension){
        super(position, dimension, new SpriteManager(
                "Dirt.png"
        ));

        Sides[] sides = {Sides.LEFT, Sides.RIGHT, Sides.BOTTOM, Sides.TOP};
        this.reactions.add(new Remove(this, Character.class, sides,1));
    }

    @Override
    public void destroy() {
        super.destroy();
        this.engine.playSound("Dig");
    }
}
