package engine;

import world.IComponent;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * TODO
 * @version 1.0
 * */
public interface IEngine {
    /**
     * TODO
     * */
    void addKeyListener(KeyListener keyListener);
    /**
     * TODO
     * */
    Context getContext(Rectangle rectangle);

    void removeEntity(IComponent element);

    void removeBlock(IComponent element);

    void removeCharacter(IComponent element);

    void lose();

    void win();

    boolean isOut(Rectangle projection);

    void incScore();

    boolean levelCompleted();
}
