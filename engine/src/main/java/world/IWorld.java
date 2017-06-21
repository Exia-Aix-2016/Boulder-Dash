package world;

import java.awt.*;
import java.util.Collection;
/**
 * TODO
 * @version 1.0
 * */
public interface IWorld {
    /**
     * TODO
     * */
    IControllable getControllable();
    /**
     * TODO
     * */
    Collection<IComponent> getComponents();
    /**
     * TODO
     * */
    Collection<IEntity> getEntities();
    /**
     * TODO
     * */
    Dimension getDimension();

    void removeEntity(IComponent element);

    void removeBlock(IComponent element);

    void removeCharacter(IComponent element);
}
