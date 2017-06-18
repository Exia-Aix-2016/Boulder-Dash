package controller;

import model.Model;

import java.util.ArrayList;
import java.util.Collection;

public class Controller {

    private Collection<TickListener> tickListeners = new ArrayList<TickListener>();
    private int ticks = 0;
    private Model model;

    Controller(Model model){
        this.model = model;
        this.addPlayer();
        this.loop();
    }

    private void addPlayer(){
        /*Element player;
        ElementControllerFactory::createPlayerController(player);*/
    }

    private void loop(){
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

