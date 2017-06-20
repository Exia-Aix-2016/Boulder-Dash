package world.elements.entity;

import world.IControllable;
import world.Permeability;
import world.Position;

import java.awt.*;

public class Character extends Entity implements IControllable{

    private static String SPRITE = "";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Character(Position position, Dimension dimension) {
        super(position, dimension, SPRITE, PERMEABILITY);
        this.setBackground(Color.RED);
    }

    @Override
    public void tick() {
        this.state.setStateType(StateType.DOWN);
        System.out.println(this.getForwardElement());
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