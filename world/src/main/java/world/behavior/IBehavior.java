package world.behavior;

import world.elements.entity.StateManager;

import java.awt.*;

public interface IBehavior {
    Rectangle getBounds();
    StateManager getStateManager();
}
