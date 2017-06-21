package world.elements.entity;

import world.Position;
import world.Permeability;

import java.awt.*;

public class Diamond extends Entity {

    private static String SPRITE = "ressources\\Sprites\\Blocks\\Diamond.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Diamond(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY);
    }

    @Override
    public void tick() {

    }
}
