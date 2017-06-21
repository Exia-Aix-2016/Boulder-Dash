package engine;

import java.util.EventListener;

public interface TickListener extends EventListener, Runnable {

    void tick();

}
