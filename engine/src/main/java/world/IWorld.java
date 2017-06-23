package world;

import java.awt.*;
import java.util.Collection;
/**
 * Its a interface allow to give a brige engine between World
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
    /**
     * TODO
     * */
    int getTimeRemaining();
    /**
     * TODO
     * */
    int getDiamonds_left();
    /**
     * TODO
     * */
    void removeEntity(IComponent element);
    /**
     * TODO
     * */
    void removeBlock(IComponent element);
    /**
     * TODO
     * */
    void removeCharacter(IComponent element);
}
