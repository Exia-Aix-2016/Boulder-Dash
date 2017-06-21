package world.elements.entity.movable;

import world.Position;
import world.Permeability;
import world.elements.entity.Entity;
import world.elements.entity.movable.SpriteEngine;

import java.awt.*;

public class Monster  extends Entity {
    private static String SPRITE = "Monster1_waiting.png";

    private SpriteEngine spriteEngineUP;
    private static String SPRITE_UP1 = "Monster1_walking1.png";
    private static String SPRITE_UP2 = "Monster1_walking2.png";

    private SpriteEngine spriteEngineDOWN;
    private static String SPRITE_DOWN1 = "Monster1_walking1.png";
    private static String SPRITE_DOWN2 = "Monster1_walking2.png";

    private SpriteEngine spriteEngineLEFT;
    private static String SPRITE_LEFT1 = "Monster1_walking1.png";
    private static String SPRITE_LEFT2 = "Monster1_walking2.png";

    private SpriteEngine spriteEngineRIGHT;
    private static String SPRITE_RIGHT1 = "Monster1_walking1.png";
    private static String SPRITE_RIGHT2 = "Monster1_walking2.png";


    private static Permeability PERMEABILITY = Permeability.PERMEABLE;

    SpriteEngine spriteEngine;

    public Monster(Position position, Dimension dimension){
        super(position, dimension, SPRITE, PERMEABILITY);
        this.spriteEngineUP = new SpriteEngine(this.SPRITE_UP1, this.SPRITE_UP2);
        this.spriteEngineDOWN = new SpriteEngine(this.SPRITE_DOWN1, this.SPRITE_DOWN2);
        this.spriteEngineLEFT = new SpriteEngine(this.SPRITE_LEFT1, this.SPRITE_RIGHT2);
        this.spriteEngineRIGHT = new SpriteEngine(this.SPRITE_RIGHT1, this.SPRITE_RIGHT2);
    }



    @Override
    public void loadBehaviors() {

    }
    @Override
    public void run() {

    }
}
