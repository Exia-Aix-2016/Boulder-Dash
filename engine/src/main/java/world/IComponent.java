package world;

import engine.IEngine;

import java.awt.*;

public interface IComponent {
    void setEngine(IEngine engine);
    Rectangle getBounds();
}
