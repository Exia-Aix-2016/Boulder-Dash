package world.elements.entity;

import world.Position;
import world.Permeability;

import java.awt.*;

public class Rock extends Entity {

    private static String SPRITE = "";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Rock(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY);
        this.setBackground(Color.GRAY);
    }

    @Override
    public void tick() {

    }
}
