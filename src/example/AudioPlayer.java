package example;

import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by acer on 21-Feb-18.
 */
public class AudioPlayer {

    public void say(String word) {
        FileInputStream in;

        // System.out.println(word);
        try {
            in = new FileInputStream(new File("miniGame.wav"));
            AudioStream audio = new AudioStream(in);

            sun.audio.AudioPlayer.player.start(audio);
            //System.out.println("Play Clicked");

        } catch (Exception e1) {
            System.out.println(e1.getMessage()+"[ Error in Method say]\n"+e1.getLocalizedMessage()+"\n"+e1.getCause());
        }
    }

}
