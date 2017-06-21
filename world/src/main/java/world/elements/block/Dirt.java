package world.elements.block;

import world.Permeability;
import world.Position;

import java.awt.*;

public class Dirt extends Block{

    private static String SPRITE = "Dirt.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;

    public Dirt(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY);
    }
}
