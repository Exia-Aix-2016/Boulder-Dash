package world.elements.entity;

import world.Dimension;
import world.Position;
import world.Permeability;
import world.elements.block.Block;

public class Diamond extends Block {

    public Diamond(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
    }
}
