package world;

import engine.IEngine;

import java.awt.*;

/**
 * TODO
 * @version 1.0
 * */
public interface IComponent {
    /**
     * TODO
     * */
    void setEngine(IEngine engine);
    /**
     * TODO
     * */
    Rectangle getBounds();
}
