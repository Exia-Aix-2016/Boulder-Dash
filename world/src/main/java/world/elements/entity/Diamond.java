package world.elements.entity;

import world.Position;
import world.Permeability;
import world.behavior.Gravity;
import world.reaction.Remove;
import world.reaction.Sides;

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
        this.reactions.add(new Remove(this, Character.class, new Sides[]{Sides.LEFT, Sides.RIGHT, Sides.TOP, Sides.BOTTOM}, 0));
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void destroy() {
        super.destroy();
        this.engine.incScore();
    }
}
