package controller.object;

import controller.TickListener;

public class ObjectController implements TickListener, Runnable {

    ObjectController(){

    }

    @Override
    public void tick() {
        System.out.println("Object Tick");
    }

    @Override
    public void run() {

    }
}
