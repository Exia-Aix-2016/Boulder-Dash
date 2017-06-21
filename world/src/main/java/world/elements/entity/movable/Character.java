package world.elements.entity.movable;

import world.Permeability;
import world.Position;
import world.behavior.ArrowKeyControl;
import world.elements.entity.Entity;

import java.awt.*;

public class Character extends Entity {


    private static String SPRITE = "Character_waiting.png";

    private SpriteEngine spriteEngineUP;
    private static String SPRITE_UP1 = "Character_up1.png";
    private static String SPRITE_UP2 = "Character_up2.png";

    private SpriteEngine spriteEngineDOWN;
    private static String SPRITE_DOWN1 = "Character_down1.png";
    private static String SPRITE_DOWN2 = "Character_down2.png";

    private SpriteEngine spriteEngineLEFT;
    private static String SPRITE_LEFT1 = "Character_left1.png";
    private static String SPRITE_LEFT2 = "Character_left2.png";

    private SpriteEngine spriteEngineRIGHT;
    private static String SPRITE_RIGHT1 = "Character_right1.png";
    private static String SPRITE_RIGHT2 = "Character_right2.png";

    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Character(Position position, Dimension dimension) {
        super(position, dimension, SPRITE, PERMEABILITY);

        this.spriteEngineUP = new SpriteEngine(this.SPRITE_UP1, this.SPRITE_UP2);
        this.spriteEngineDOWN = new SpriteEngine(this.SPRITE_DOWN1, this.SPRITE_DOWN2);
        this.spriteEngineLEFT = new SpriteEngine(this.SPRITE_LEFT1, this.SPRITE_RIGHT2);
        this.spriteEngineRIGHT = new SpriteEngine(this.SPRITE_RIGHT1, this.SPRITE_RIGHT2);
    }

    @Override
    public void run() {
        super.run();
        //System.out.println(this.stateManager.getCurrentState());
       /* this.stateManager.pushState(StateType.WAITING);
        System.out.println("tick Character ");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //stateManager.tickStateManager();*/

    }

    @Override
    public void loadBehaviors() {
        this.behaviors.add(new ArrowKeyControl(this, this.engine));
    }

    @Override
    public void destroy() {
        this.engine.removeCharacter(this);
    }
}