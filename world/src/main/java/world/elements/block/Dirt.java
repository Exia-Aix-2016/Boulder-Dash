package world.elements.block;

import world.Dimension;
import world.Position;
import world.Permeability;

import java.awt.*;

public class Dirt extends Block{

    public Dirt(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
        this.setBackground(Color.ORANGE);
    }
}
