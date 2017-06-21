package world.elements.block;

import world.Position;
import world.Permeability;

import java.awt.*;

public class Wall extends Block{
    private static String SPRITE = "Wall.png";
    private static Permeability PERMEABILITY = Permeability.BLOCKING;
    public Wall(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY);
    }
}