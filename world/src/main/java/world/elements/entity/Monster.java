package world.elements.entity;

import world.Dimension;
import world.Position;
import world.element.Permeability;
import world.elements.block.Block;

public class Monster extends Block {

    public Monster(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
    }
}
