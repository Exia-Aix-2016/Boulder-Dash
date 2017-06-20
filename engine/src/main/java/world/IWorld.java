package world;

import engine.TickListener;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public interface IWorld {
    IControllable getControllable();
    Collection<JComponent> getComponents();
    Collection<TickListener> getTickListeners();
    Dimension getDimension();
}
