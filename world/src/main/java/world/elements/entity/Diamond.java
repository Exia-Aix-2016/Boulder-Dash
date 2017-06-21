package world.elements.entity;

import world.Position;
import world.Permeability;

import java.awt.*;

public class Diamond extends Entity {

    private static String SPRITE = "";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Diamond(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY);
        this.setBackground(Color.BLUE);
    }

    @Override
    public void tick() {
        System.out.println("tick Diamond");
    }

    @Override
    public void loadBehaviors() {

    }
}
