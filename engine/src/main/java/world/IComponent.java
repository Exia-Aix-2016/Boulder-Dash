package world;

import engine.IEngine;

import java.awt.*;

/**
 * interface IComponent
 * regroup the methods used by a component of the engine
 * */
public interface IComponent {
    /**
     * setEngine
     * configure the engine of tne component
     * @param IEngine
     * */
    void setEngine(IEngine engine);
    /**
     * getBounds
     * return the bounds of the component
     * @see Rectangle
     * @return Rectangle
     * */
    Rectangle getBounds();
}
