package world.elements.entity;

import world.IControllable;
import world.Permeability;
import world.Position;
import world.elements.block.Dirt;
import world.elements.block.Wall;

import java.awt.*;

public class Character extends Entity implements IControllable{

    private static String SPRITE = "ressources\\Sprites\\Character\\Character_waiting.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Character(Position position, Dimension dimension) {
        super(position, dimension, SPRITE, PERMEABILITY);
    }

    @Override
    public void tick() {
        
        stateManager.tickStateManager();
    }

    @Override
    public void goLeft() {





    }

    @Override
    public void goRight() {


    }

    @Override
    public void goUp() {

    }

    @Override
    public void goDown() {

    }

    @Override
    public void goRest() {


    }
}