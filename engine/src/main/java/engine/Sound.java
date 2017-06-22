package engine;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.InputStream;

public class Sound {

    public  void playSound(final String filename) {

        try {
            InputStream in = getClass().getResourceAsStream(filename + ".wav");
            AudioStream audioStream = new AudioStream(in);

            AudioPlayer.player.start(audioStream);
        }catch (Exception e){

        }

    }
}
