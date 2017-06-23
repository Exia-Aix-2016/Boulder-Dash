package Hud;

import engine.IEngine;
import engine.TickListener;

import java.util.Optional;

/**
 * Created by hougo on 23/06/2017.
 */
public class Timer implements TickListener {

    private Hud hud;
    private Thread thread;
    private int time;
    private IEngine engine;
    private int millis = 0;

    public Timer(IEngine engine, Hud hud, int time){
        this.hud = hud;
        this.time = time;
        this.engine = engine;
        this.hud.addInfo(new Info("Time", this.time));
    }

    private void updateHud(){
        Optional<Info> info = this.hud.getInfo("Time");

        info.ifPresent((Info i) -> {
            i.set(this.time);
        });
    }

    @Override
    public void tick() {
        if (this.thread == null) {
            this.thread = new Thread(this);
        }
        if (!this.thread.isAlive()) {
            this.thread = new Thread(this);
            this.thread.start();
        }
    }

    @Override
    public void run() {

        this.millis += 100;

        if (this.millis >= 1000){
            this.time -= 1;
            this.updateHud();
            this.millis = 0;
        }

        if (this.time <= 0){
            this.engine.lose();
        }
    }
}
