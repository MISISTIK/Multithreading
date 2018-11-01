package ua.homework.DauchenSoldatenUnterOfficieren;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        try{
            final JFXPanel fxPanel = new JFXPanel();
            String uriString = new File("droeloe-in-time.mp3").toURI().toString();
            Media hit = new Media(uriString);
            MediaPlayer player = new MediaPlayer(hit);

            player.setStartTime(new Duration(35000));
            player.setStopTime(new Duration(50000));
            System.out.println("Start time = " + player.getStartTime().toString());
            System.out.println(player.getStatus().toString());
            player.play();
            System.out.println(player.getStatus().toString());
            TimeUnit.SECONDS.sleep(5);
            player.stop();
            System.out.println(player.getStatus().toString());
            System.exit(0);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
        }
    }
}
