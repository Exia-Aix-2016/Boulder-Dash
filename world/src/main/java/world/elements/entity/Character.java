package world.elements.entity;

import engine.Sound;
import world.Permeability;
import world.Position;
import world.behavior.ArrowKeyControl;
import world.reaction.Remove;
import world.reaction.Sides;

import java.awt.*;

public class Character extends Entity{


    private static String SPRITE = "Character_waiting.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Character(Position position, Dimension dimension) {
        super(position, dimension, SPRITE, PERMEABILITY, 10);
    }

    private Sound sound = new Sound();

    @Override
    public void run() {
        super.run();

    }

    @Override
    public void loadBehaviors() {
        this.behaviors.add(new ArrowKeyControl(this, this.engine));
        Sides[] sides = {Sides.LEFT};
        this.reactions.add(new Remove(this, Monster.class, sides,0));
    }

    @Override
    public void destroy() {
        this.engine.removeCharacter(this);
        this.engine.lose();
    }

    @Override
    public boolean hasFinish() {
        return this.engine.levelCompleted();
    }
}