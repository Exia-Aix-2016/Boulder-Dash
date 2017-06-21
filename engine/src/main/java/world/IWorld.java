package world;

import java.awt.*;
import java.util.Collection;

public interface IWorld {
    IControllable getControllable();
    Collection<IComponent> getComponents();
    Collection<IEntity> getEntities();
    Dimension getDimension();
}
