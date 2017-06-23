package world.elements.entity;

import Hud.Info;
import engine.Sound;
import world.Position;
import world.behavior.Gravity;
import world.elements.SpriteManager;
import world.reaction.Heap;
import world.reaction.Remove;
import world.reaction.Sides;

import java.awt.*;
import java.util.Optional;
/**
 * Diamond Entity
 * @see Entity
 * */
public class Diamond extends Entity {

    public Diamond(Position position, Dimension dimension){
        super(position, dimension, new SpriteManager(
                new String[]{"Diamond.png", "Diamond2.png","Diamond3.png","Diamond4.png"}
        ), 20);

        this.reactions.add(new Remove(this, Character.class, new Sides[]{Sides.LEFT, Sides.RIGHT, Sides.TOP, Sides.BOTTOM}));
        this.reactions.add(new Heap(this, Rock.class));
        this.reactions.add(new Heap(this, Diamond.class));
    }

    @Override
    public void loadBehaviors() {
        this.behaviors.add(new Gravity(this));
    }

    @Override
    public void run() {
        super.run();

    }

    @Override
    public void destroy() {
        this.engine.getInfo("Score").get().add(50);
        Info dR = this.engine.getInfo("Diamond remaining").get();
        if (dR.get() > 0){
            dR.decrement();
        }
        this.engine.playSound("Pick");
        super.destroy();
    }
}
