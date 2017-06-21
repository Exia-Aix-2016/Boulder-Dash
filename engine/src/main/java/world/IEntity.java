package world;

import engine.TickListener;

public interface IEntity extends TickListener, IComponent, Runnable{
    void loadBehaviors();
}
