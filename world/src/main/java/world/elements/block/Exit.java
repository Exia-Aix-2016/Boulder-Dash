package world.elements.block;

import world.Permeability;
import world.Position;
import world.elements.entity.Character;
import world.reaction.EndGame;
import world.reaction.Sides;

import java.awt.*;

public class Exit extends Block{

    private static String SPRITE = "Exit_close.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Exit(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY);
        this.reactions.add(new EndGame(this, Character.class, new Sides[]{Sides.BOTTOM, Sides.TOP, Sides.LEFT, Sides.RIGHT}));
    }

    @Override
    public void destroy() {
        super.destroy();
        this.engine.win();
    }
}