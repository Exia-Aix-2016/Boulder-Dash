package engine;

import java.util.ArrayList;
import java.util.Collection;

public class TickGenerator implements Runnable{

    private Collection<TickListener> tickListeners = new ArrayList<>();

    public void addTickListener(TickListener tickListener){
        tickListeners.add(tickListener);
    }

    public void removeTickListener(TickListener tickListener){
        tickListeners.remove(tickListener);
    }

    private void fireTick(){
        for (TickListener tickListener: tickListeners){
            tickListener.tick();
        }
    }

    @Override
    public void run() {
        while (true){
            this.fireTick();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
