package world.elements.block;

import world.Dimension;
import world.Position;
import world.element.Permeability;

public class Dirt extends Block{

    public Dirt(Position position, Dimension dimension, String sprite, Permeability permeability){
        super(position, dimension, sprite, permeability);
    }
}
