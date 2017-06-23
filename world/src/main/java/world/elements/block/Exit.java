package world.elements.block;

import world.Position;
import world.elements.SpriteManager;
import world.elements.entity.Character;
import world.reaction.EndGame;
import world.reaction.Sides;

import java.awt.*;

public class Exit extends Block{

    public Exit(Position position, Dimension dimension){
        super(position, dimension, new SpriteManager(
                new String[]{"Exit_close.png", "Exit_close2.png","Exit_close3.png","Exit_close4.png"}
        ));
        this.reactions.add(new EndGame(this, Character.class, new Sides[]{Sides.BOTTOM, Sides.TOP, Sides.LEFT, Sides.RIGHT}));
    }

    @Override
    public void destroy() {
        super.destroy();
        this.engine.win();
    }
}