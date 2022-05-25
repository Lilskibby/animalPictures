import jaco.mp3.player.MP3Player;

import java.io.File;

public class Sound {


    public void playSound(String src)
    {
        try {

            File f = new File(src);

            MP3Player mp3Player = new MP3Player(f);
            mp3Player.play();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


}