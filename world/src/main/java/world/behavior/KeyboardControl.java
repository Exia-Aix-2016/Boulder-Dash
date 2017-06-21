package world.behavior;

import engine.IEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardControl extends Behavior implements KeyListener {

    private IEngine engine;

    public KeyboardControl(IBehavior elements, IEngine engine) {
        super(elements);
        this.engine = engine;

        this.engine.addKeyListener(this);
    }

    @Override
    public void check() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("coucou");
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
