package world.behavior;

import engine.IEngine;
import world.elements.entity.IMovement;

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

    /**
     * ArrowKeyControl
     * the constructor of the class. Here to move an objet, thanks to an engine
     * @see IMovement
     * @see IEngine
     * */
    public ArrowKeyControl(IMovement elements, IEngine engine) {
        super(elements);
        this.engine = engine;

        this.engine.addKeyListener(this);
    }

    @Override
    public void execute() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("coucou");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
