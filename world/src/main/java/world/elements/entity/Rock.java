package world.elements.entity;

import world.Position;
import world.Permeability;
import world.behavior.Gravity;
import world.reaction.Heap;
import world.reaction.Push;
import world.reaction.Sides;

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
        this.reactions.add(new Heap(this, Rock.class));
        this.reactions.add(new Push(this, Character.class, new Sides[]{Sides.LEFT, Sides.RIGHT}, 5));
    }
    @Override
    public void run() {
        super.run();
    }
}
