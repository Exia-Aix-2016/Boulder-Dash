package engine;

import world.IComponent;

import javax.xml.bind.Element;
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
}
