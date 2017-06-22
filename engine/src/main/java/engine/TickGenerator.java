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
        while (true){
            this.fireTick();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
