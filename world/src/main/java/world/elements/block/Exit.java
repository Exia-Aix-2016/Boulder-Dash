package world.elements.block;

import world.Position;
import world.Permeability;

import java.awt.*;

public class Exit extends Block{

    private static String SPRITE = "Exit_close.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Exit(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY);
    }
}