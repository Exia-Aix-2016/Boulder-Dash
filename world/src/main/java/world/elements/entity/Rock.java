package world.elements.entity;

import world.Position;
import world.Permeability;
import world.behavior.Gravity;

import java.awt.*;

public class Rock extends Entity {

    private static String SPRITE = "Rock.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Rock(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY, 30);
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
