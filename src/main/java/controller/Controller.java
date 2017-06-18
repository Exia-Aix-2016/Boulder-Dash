package controller;

import java.util.ArrayList;
import java.util.Collection;

public class Controller {

    private Collection<TickListener> tickListeners = new ArrayList<TickListener>();
    private int ticks = 0;

    Controller(){

        loop();
    }

    public void loop(){
        while (true){
            fireTick();
            try {
                Thread.sleep(50);
            } catch (Exception e){
                System.err.println(e);
            }
        }
    }

    private void fireTick(){
        for (TickListener tickListener: tickListeners){
            ticks++;
            tickListener.tick(ticks);
        }
    }
}

