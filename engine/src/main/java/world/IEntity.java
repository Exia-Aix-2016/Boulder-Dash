package world;

import engine.TickListener;
/**
 * Interface Entity
 * Represente the entity element
 * @see TickListener
 * @see IComponent
 * @see Runnable
 * @version 1.0
 * */
public interface IEntity extends TickListener, IComponent, Runnable{
    /**
     * Allow to load entity's behavios
     * */
    void loadBehaviors();
}
