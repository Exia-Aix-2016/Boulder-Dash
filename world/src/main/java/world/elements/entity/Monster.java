package world.elements.entity;

import world.Position;
import world.behavior.Behavior;
import world.behavior.IAHostile;
import world.behavior.MonsterMove;
import world.elements.SpriteManager;
import world.reaction.Kill;
import world.reaction.Remove;
import world.reaction.Sides;

import java.awt.*;

/**
 *Rock entity
 * @see Entity
 * */
public class Monster extends Entity   {

    public Monster(Position position, Dimension dimension){
        super(position, dimension, new SpriteManager(
                new String[]{"Monster1_waiting.png"},
                new String[]{"Monster1_walking1.png", "Monster1_walking2.png"},
                new String[]{"Monster1_walking1.png", "Monster1_walking2.png"},
                new String[]{"Monster1_walking1.png", "Monster1_walking2.png"},
                new String[]{"Monster1_walking1.png", "Monster1_walking2.png"}
        ), 30);
        this.reactions.add(new Remove(this, Rock.class, new Sides[]{Sides.TOP}));
        this.reactions.add(new Kill(this, Character.class, new Sides[]{Sides.LEFT, Sides.RIGHT, Sides.TOP, Sides.BOTTOM}));
    }

    @Override
    public void loadBehaviors() {
        this.behaviors.add(new MonsterMove(this) {
        });

    }
    @Override
    public void run() {
        super.run();

    }
    @Override
    public void destroy() {
        this.engine.getInfo("Score").get().add(100);
        this.engine.playSound("Explosion");
        super.destroy();
    }
}
