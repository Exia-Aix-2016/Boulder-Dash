package engine;

import java.util.EventListener;

/**
 * A tickListerner represente all game's entities. it will be run() by the TickGenerator
 * @see TickGenerator
 * @version 1.0
 * */
public interface TickListener extends EventListener, Runnable {
    /**
     * This method is call by the TickGenerator
     * @see TickGenerator
     * */
    void tick();

}
