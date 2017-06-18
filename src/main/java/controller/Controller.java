package controller;

import model.Model;

import java.util.ArrayList;
import java.util.Collection;

public class Controller extends Thread{

    private Collection<TickListener> tickListeners = new ArrayList<TickListener>();
    private int ticks = 0;
    private Model model;

    public Controller(Model model){
        this.model = model;
        this.addPlayer();
    }

    private void addPlayer(){
        /*Element player;
        ElementControllerFactory::createPlayerController(player);*/
    }

    @Override
    public void run(){
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
        //System.out.println("tick");
        for (TickListener tickListener: tickListeners){
            ticks++;
            tickListener.tick(ticks);
        }
    }
}

