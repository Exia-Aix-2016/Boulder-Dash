package world.behavior;

import engine.IEngine;
import javafx.scene.input.KeyCode;
import world.elements.entity.IMovement;
import world.elements.entity.StateType;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * class ArrowKeyControl
 * needed to move an element in the world thanks to an arrow key
 * @see Behavior
 * @see KeyListener
 * */

public class ArrowKeyControl extends Behavior implements KeyListener{

    private IEngine engine;
    private int lastKey;

    /**
     * ArrowKeyControl
     * the constructor of the class. Here to move an objet, thanks to an engine
     * @see IMovement
     * @see IEngine
     * */
    public ArrowKeyControl(IMovement element, IEngine engine) {
        super(element);
        this.engine = engine;

        this.engine.addKeyListener(this);
    }
    /**
     * TODO
     * */
    @Override
    public void execute() {
        switch (this.lastKey){
            case KeyEvent.VK_UP:
                this.element.goUp();
                break;
            case KeyEvent.VK_DOWN:
                this.element.goDown();
                break;
            case KeyEvent.VK_LEFT:
                this.element.goLeft();
                break;
            case KeyEvent.VK_RIGHT:
                this.element.goRight();
                break;
            default:
                this.element.goRest();
        }
    }

    /**
     * TODO
     * */
    @Override
    public void keyTyped(KeyEvent e) {

    }
    /**
     * TODO
     * */
    @Override
    public void keyPressed(KeyEvent e) {
        this.lastKey = e.getKeyCode();
    }
    /**
     * TODO
     * */
    @Override
    public void keyReleased(KeyEvent e) {
        this.lastKey = -1;
    }
}
