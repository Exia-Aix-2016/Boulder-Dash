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
     * the constructor of the class. Here to move an object, thanks to an engine
     * @param element element
     * @param engine engine
     * @see IMovement
     * @see IEngine
     * */
    public ArrowKeyControl(IMovement element, IEngine engine) {
        super(element);
        this.engine = engine;

        this.engine.addKeyListener(this);
    }
    /**
     * execute
     * called by an element and use the code of the last key pressed to use the specific method to move the element
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
     * keyTyped
     * used when a key is pressed
     * @param e represente the event
     * */
    @Override
    public void keyTyped(KeyEvent e) {

    }
    /**
     * keyPressed
     * get the key code of the keyEvent past in the method
     * @param e represente the event
     * */
    @Override
    public void keyPressed(KeyEvent e) {
        this.lastKey = e.getKeyCode();
    }
    /**
     * keyReleased
     * invoked when the key is released, and set it key code to -1, which is attached to nothing
     * @param e represente the event
     * */
    @Override
    public void keyReleased(KeyEvent e) {
        this.lastKey = -1;
    }
}
