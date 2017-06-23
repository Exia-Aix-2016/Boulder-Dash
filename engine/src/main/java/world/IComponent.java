package world;

import engine.IEngine;

import java.awt.*;

/**
 * Its a interface Component
 * allow to give a brige engine between entities
 * @version 1.0
 * */
public interface IComponent {
    /**
     * Allow to add engine in Component
     * */
    void setEngine(IEngine engine);
    /**
     * Get the bounds Component
     * */
    Rectangle getBounds();
}
