package world;

import java.awt.*;
import java.util.Collection;
/**
 * Its a interface allow to give a brige engine between World
 * @version 1.0
 * */
public interface IWorld {
    /**
     * @return a controllable
     * no implement
     * @see IControllable
     * */
    IControllable getControllable();
    /**
     * @return a collection of all Components in the map (entities + blocks)
     * @see IComponent
     * @see Collection
     * */
    Collection<IComponent> getComponents();
    /**
     * @return a collection of all entities in the map
     * @see IEntity
     * @see Collection
     * */
    Collection<IEntity> getEntities();
    /**
     * @return the map Dimension
     * @see Dimension
     * */
    Dimension getDimension();
    /**
     * @return the remaining time
     * */
    int getTimeRemaining();
    /**
     * @return the number of diamonds
     * */
    int getDiamonds_left();
    /**
     * Allow to remove an entity
     * @param element represente the element to remove
     * @see IComponent
     * */
    void removeEntity(IComponent element);
    /**
     * Allow to remove the block
     * @param element represente the element to remove.
     * @see IComponent
     * */
    void removeBlock(IComponent element);
    /**
     * Allow to Remove a character
     * @param element represente the element to remove
     * @see IComponent
     * */
    void removeCharacter(IComponent element);
}
