package engine;

import java.util.ArrayList;
import java.util.Collection;

/**
 * TODO
 * @version 1.0
 * */
public class TickGenerator implements Runnable{

    private int missTick = 0;

    private Collection<TickListener> tickListeners = new ArrayList<>();

    public void addTickListener(TickListener tickListener){
        tickListeners.add(tickListener);
    }

    public void removeTickListener(TickListener tickListener){
        tickListeners.remove(tickListener);
    }

    public void removeAllTickListeners(){
        this.tickListeners.clear();
    }

    public int getMissTick() {
        return missTick;
    }
    private void fireTick(){
        for(TickListener listener : tickListeners) {
            listener.tick();

        }
    }

    /**
     * @see Runnable
     * */
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                this.fireTick();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
