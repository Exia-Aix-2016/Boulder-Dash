package world.elements.entity;

import world.Position;
import world.behavior.Gravity;
import world.elements.SpriteManager;
import world.reaction.Heap;
import world.reaction.Push;
import world.reaction.Sides;

import java.awt.*;

public class Rock extends Entity {

    public Rock(Position position, Dimension dimension){
        super(position, dimension, new SpriteManager(
                new String[]{"Rock.png", "Rock2.png","Rock3.png","Rock4.png"}
        ), 30);

        this.reactions.add(new Heap(this, Rock.class));
        this.reactions.add(new Heap(this, Diamond.class));
        this.reactions.add(new Push(this, Character.class, new Sides[]{Sides.LEFT, Sides.RIGHT}, 5));
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
