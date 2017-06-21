package world;

import engine.TickListener;
/**
 * TODO
 * @version 1.0
 * */
public interface IEntity extends TickListener, IComponent, Runnable{
    /**
     * TODO
     * */
    void loadBehaviors();
}
