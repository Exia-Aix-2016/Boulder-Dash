package world;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public interface IWorld {
    IControllable getControllable();
    Collection<JComponent> getComponents();
    Dimension getDimension();
}
