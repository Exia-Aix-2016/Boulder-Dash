package engine;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Its a Thread which allow to play a sound
 * @see Thread
 * */
public class Sound extends Thread{
    private String filename;
    private boolean loop;

    Sound(String filename){
        this(filename, false);
    }

    Sound(String filename, boolean loop){
        this.filename = filename;
        this.loop = loop;
    }

    /**
     * The sound is load and play in a thread no slow down the engine.
     * */
    @Override
    public void run() {
        try {
            InputStream in = new BufferedInputStream(this.getClass().getResourceAsStream(this.filename + ".wav"));
            Clip clip = AudioSystem.getClip();

            clip.open(AudioSystem.getAudioInputStream(in));
            if (this.loop){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            clip.start();
        }catch (Exception e){
            System.err.println(e);
        }

    }
}
