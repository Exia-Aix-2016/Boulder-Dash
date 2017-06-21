package world.behavior;

import engine.IEngine;
import world.elements.entity.IMovement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ArrowKeyControl extends Behavior implements KeyListener{

    private IEngine engine;

    public ArrowKeyControl(IMovement element, IEngine engine) {
        super(element);
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
        switch (e.getKeyCode()){
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
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.element.goRest();
    }
}
