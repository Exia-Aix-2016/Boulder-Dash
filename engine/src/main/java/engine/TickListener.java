package engine;

import java.util.EventListener;

public interface TickListener extends EventListener {
    void tick();
    void setEngine(Engine engine);
}
