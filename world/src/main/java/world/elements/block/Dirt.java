package world.elements.block;

import world.Permeability;
import world.Position;
import world.elements.entity.Character;
import world.reaction.Reaction;
import world.reaction.Remove;

import java.awt.*;

public class Dirt extends Block{

    private static String SPRITE = "ressources\\Sprites\\Blocks\\Dirt.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;

    public Dirt(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY);

        Reaction test = new Remove(this, Character.class, 20);
        this.reactions.add(test);
    }
}
