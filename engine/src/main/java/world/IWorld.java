package world;

import javax.swing.*;
import java.util.Collection;

public interface IWorld {
    IControllable getControllable();
    Collection<JComponent> getComponents();
}
