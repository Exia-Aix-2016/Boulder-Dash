package world.elements.entity;

import world.Dimension;
import world.Position;
import world.element.Permeability;
import world.elements.block.Block;

public class Rock extends Block {

    public Rock(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
    }
}
