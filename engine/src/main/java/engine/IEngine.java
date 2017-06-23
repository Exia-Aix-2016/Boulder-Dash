package engine;

import Hud.Info;
import world.IComponent;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.Optional;

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

    Optional<Info> getInfo(final String name);

    void lose();

    void win();

    boolean isOut(Rectangle projection);

    boolean levelCompleted();

    void playSound(String filename);
}
