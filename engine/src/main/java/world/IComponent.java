package world;

import engine.Engine;

import java.awt.*;

public interface IComponent {
    void setEngine(Engine engine);
    Rectangle getBounds();
}
