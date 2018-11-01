package ua.homework.DauchenSoldatenUnterOfficieren;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Main {
    volatile static MediaPlayer player;
    public static void main(String[] args) {
        try{
            final JFXPanel fxPanel = new JFXPanel();
            String uriString = new File("droeloe-in-time.mp3").toURI().toString();
            Media hit = new Media(uriString);
            player = new MediaPlayer(hit);

            new Thread(() -> {
                while(true) {
                    System.out.println(String.format("%.2f",player.getCurrentTime().toSeconds()) + " sec");
                    try {
                        Thread.sleep(350);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            player.setStartTime(new Duration(58000));
            player.setStopTime(new Duration(60000));
            player.setOnEndOfMedia(() -> {player.seek(Duration.ZERO); player.play();});
            System.out.println("Start time = " + player.getStartTime().toString());
            System.out.println(player.getStatus().toString());
            player.play();
            System.out.println(player.getStatus().toString());
            TimeUnit.SECONDS.sleep(6);
            player.pause();
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println(player.getStatus().toString());
            player.play();
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println(player.getStatus().toString());
            TimeUnit.SECONDS.sleep(6);
            System.exit(0);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
        }
    }
}
