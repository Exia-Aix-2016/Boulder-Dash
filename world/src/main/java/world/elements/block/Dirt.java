package world.elements.block;

import world.Permeability;
import world.Position;
import world.elements.entity.Character;
import world.reaction.Remove;
import world.reaction.Sides;

import java.awt.*;

public class Dirt extends Block{

    private static String SPRITE = "Dirt.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;

    public Dirt(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY);

        Sides[] sides = {Sides.LEFT, Sides.RIGHT, Sides.BOTTOM, Sides.TOP};
        this.reactions.add(new Remove(this, Character.class, sides,5));
    }
}
