package world.elements.entity;

import world.Dimension;
import world.Position;
import world.Permeability;
import world.elements.block.Block;

import java.awt.*;

public class Monster extends Block {

    public Monster(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
        this.setBackground(Color.GREEN);
    }
}