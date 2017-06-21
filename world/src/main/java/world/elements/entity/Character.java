package world.elements.entity;

import world.Permeability;
import world.Position;
import world.behavior.ArrowKeyControl;

import java.awt.*;

public class Character extends Entity{


    private static String SPRITE = "Character_waiting.png";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Character(Position position, Dimension dimension) {
        super(position, dimension, SPRITE, PERMEABILITY, 20);
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