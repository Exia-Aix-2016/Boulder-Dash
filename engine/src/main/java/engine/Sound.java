package engine;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.InputStream;

public class Sound extends Thread{
    private String filename;

    Sound(String filename){
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            InputStream in = getClass().getResourceAsStream(this.filename + ".wav");
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
        }catch (Exception e){

        }

    }
}
