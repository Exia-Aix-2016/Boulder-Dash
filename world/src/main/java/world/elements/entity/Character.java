package world.elements.entity;

import world.Position;
import world.behavior.ArrowKeyControl;
import world.elements.SpriteManager;
import world.reaction.InertiaRemove;
import world.reaction.Remove;
import world.reaction.Sides;

import java.awt.*;

/**
 *Character Entity
 * the character will be control by player
 * @see Entity
 * */
public class Character extends Entity{

    public Character(Position position, Dimension dimension) {
        super(position, dimension, new SpriteManager(
                new String[]{"Character_waiting.png"},
                new String[]{"Character_up.png"},
                new String[]{"Character_down1.png", "Character_down2.png"},
                new String[]{"Character_left1.png", "Character_left2.png"},
                new String[]{"Character_right1.png", "Character_right2.png"}
        ),10);

        this.reactions.add(new Remove(this, Monster.class, new Sides[]{Sides.LEFT, Sides.RIGHT, Sides.TOP, Sides.BOTTOM}));
        this.reactions.add(new InertiaRemove(this, Rock.class, new Sides[]{Sides.TOP}));
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
        this.engine.lose();
    }

    @Override
    public boolean hasFinish() {
        return this.engine.levelCompleted();
    }
}