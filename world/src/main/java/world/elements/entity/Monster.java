package world.elements.entity;

import world.Position;
import world.Permeability;

import java.awt.*;

public class Monster extends Entity {
    private static String SPRITE = "Monster1_waiting.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Monster(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY, 30);
    }



    @Override
    public void loadBehaviors() {

    }
    @Override
    public void run() {

    }
}
