package engine;

import java.util.EventListener;

/**
 * TODO
 * @version 1.0
 * */
public interface TickListener extends EventListener, Runnable {

    /**
     * TODO
     * */
    void tick();

}
