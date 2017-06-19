package world.elements.entity;

import world.Dimension;
import world.Position;
import world.Permeability;
import world.elements.block.Block;

import java.awt.*;

public class Diamond extends Entity {

    private static String SPRITE = "";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Diamond(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY);
        this.setBackground(Color.BLUE);
    }
}
