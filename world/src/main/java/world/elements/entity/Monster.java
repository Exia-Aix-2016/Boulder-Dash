package world.elements.entity;

import world.Position;
import world.behavior.MonsterMove;
import world.elements.SpriteManager;
import world.reaction.Remove;
import world.reaction.Sides;

import java.awt.*;

public class Monster extends Entity {

    public Monster(Position position, Dimension dimension){
        super(position, dimension, new SpriteManager(
                new String[]{"Monster1_waiting.png"},
                new String[]{"Monster1_walking1.png", "Monster1_walking2.png"},
                new String[]{"Monster1_walking1.png", "Monster1_walking2.png"},
                new String[]{"Monster1_walking1.png", "Monster1_walking2.png"},
                new String[]{"Monster1_walking1.png", "Monster1_walking2.png"}
        ), 30);
        this.reactions.add(new Remove(this, Rock.class, new Sides[]{Sides.LEFT, Sides.RIGHT, Sides.TOP, Sides.BOTTOM}, 0));
    }

    @Override
    public void loadBehaviors() {
        this.behaviors.add(new MonsterMove(this));

    }
    @Override
    public void run() {
        super.run();

    }
}
