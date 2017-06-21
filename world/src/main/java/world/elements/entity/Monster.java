package world.elements.entity;

import world.Position;
import world.Permeability;

import java.awt.*;

public class Monster extends Entity {
    private static String SPRITE = "ressources\\Sprites\\Monsters\\Monster1_waiting.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Monster(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY);
    }

    @Override
    public void tick() {

    }
}
