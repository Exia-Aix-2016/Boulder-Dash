package world.elements.entity;

import world.Permeability;
import world.Position;
import world.behavior.ArrowKeyControl;

import java.awt.*;

public class Character extends Entity{


    private static String SPRITE = "Character_waiting.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Character(Position position, Dimension dimension) {
        super(position, dimension, SPRITE, PERMEABILITY, 10);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void loadBehaviors() {
        this.behaviors.add(new ArrowKeyControl(this, this.engine));
    }

    @Override
    public void destroy() {
        this.engine.removeCharacter(this);
    }
}