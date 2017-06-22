package world.elements.entity;

import engine.Sound;
import world.Position;
import world.behavior.Gravity;
import world.elements.SpriteManager;
import world.reaction.Remove;
import world.reaction.Sides;

import java.awt.*;

public class Diamond extends Entity {

    public Diamond(Position position, Dimension dimension){
        super(position, dimension, new SpriteManager(
                new String[]{"Diamond.png", "Diamond2.png","Diamond3.png","Diamond4.png"}
        ), 20);
    }

    Sound sound = new Sound();

    @Override
    public void loadBehaviors() {
        this.behaviors.add(new Gravity(this));
        this.reactions.add(new Remove(this, Character.class, new Sides[]{Sides.LEFT, Sides.RIGHT, Sides.TOP, Sides.BOTTOM}));
    }

    @Override
    public void run() {
        super.run();

    }

    @Override
    public void destroy() {
        this.engine.getInfo("Score").get().add(50);
        this.engine.getInfo("Diamond remaining").get().decrement();
        sound.playSound("Pick");
        super.destroy();
    }
}
