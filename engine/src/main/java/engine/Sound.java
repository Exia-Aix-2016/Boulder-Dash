package engine;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.InputStream;

/**
 * Its a Thread which allow to play a sound
 * @see Thread
 * */
public class Sound extends Thread{
    private String filename;

    Sound(String filename){
        this.filename = filename;
    }

    /**
     * The sound is load and play in a thread no slow down the engine.
     * */
    @Override
    public void run() {
        try {
            InputStream in = getClass().getResourceAsStream(this.filename + ".wav");
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
        }catch (Exception e){
            System.err.println(e);
        }

    }
}
