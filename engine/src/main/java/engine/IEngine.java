package engine;

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
}
