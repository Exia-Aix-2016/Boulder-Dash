package engine;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The tickGenerator allow Give a rhythm to the entities(TickListener)
 * @see TickListener
 * @see Runnable
 * @version 1.0
 * */
public class TickGenerator implements Runnable{

    private Collection<TickListener> tickListeners = new ArrayList<>();

    /**
     * Allow to add a TickListener
     * @param tickListener add the tickListener give in parameter
     * */
    public void addTickListener(TickListener tickListener){
        tickListeners.add(tickListener);
    }

    /**
     * Allow to remove a TickListener
     * @param tickListener Remove the tickListener give in parameters
     * */
    public synchronized void removeTickListener(TickListener tickListener){
        tickListeners.remove(tickListener);
    }

    /**
     * Remove all TickListeners
     * */
    public void removeAllTickListeners(){
        this.tickListeners.clear();
    }

    /**
     * Call the tick() method for all TickListener
     * */
    private synchronized void fireTick(){
        for(TickListener listener : tickListeners) {
            listener.tick();

        }
    }

    /**
     * The TickGenerator call the tick() method in TickListeners every 100 milliseconds
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
