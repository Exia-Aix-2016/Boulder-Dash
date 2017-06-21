package world.behavior;

import engine.IEngine;
import world.elements.entity.IMovement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ArrowKeyControl extends Behavior implements KeyListener{

    private IEngine engine;

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
