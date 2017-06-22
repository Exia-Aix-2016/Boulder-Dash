package world.elements.entity;

import world.Position;
import world.Permeability;
import world.behavior.Gravity;

import java.awt.*;

public class Diamond extends Entity {

    private static String SPRITE = "Diamond.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Diamond(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY, 20);
    }

    @Override
    public void loadBehaviors() {
        this.behaviors.add(new Gravity(this));
    }

    @Override
    public void run() {
        super.run();
    }
}
