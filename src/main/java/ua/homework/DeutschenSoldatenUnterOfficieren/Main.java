package ua.homework.DeutschenSoldatenUnterOfficieren;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//TODO put semaphore release in MusicPlayer Class
public class Main {

    volatile static MediaPlayer player;
    private static int THREAD_COUNT = 5;
    static CountDownLatch BARRIER = new CountDownLatch(1);
    static Semaphore semaphore = new Semaphore(1);
    static int sitSec = 3;
    static boolean isFirstTimePlayed = true;


    public static void main(String[] args) {
        final JFXPanel fxPanel = new JFXPanel();
        Chair chair = new Chair();
        Thread[] pool = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            pool[i] = new DeutschenSoldaten(String.valueOf(i + 1), chair).getThread();
        }
        mediaPlayerInit();

        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                pool[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        print("===== GAME ENDS!=====", CmdColor.ANSI_PURPLE);
        System.exit(0);
    }

    /*public static void main(String[] args) throws InterruptedException {
        final JFXPanel fxPanel = new JFXPanel();
        mediaPlayerInit();
        Thread.sleep(20000);
        System.exit(0);
    }*/

    private static void func() {
        try {
            print("===== GAME STARTS!=====", CmdColor.ANSI_PURPLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void print(String s, CmdColor color) {
        System.out.println(color.getColor() + s + CmdColor.ANSI_RESET.getColor());
    }

    static void mediaPlayerInit() {
        String uriString = new File("DROELOE - In Time.m4a").toURI().toString();
        Media hit = new Media(uriString);
        player = new MediaPlayer(hit);
        player.setStartTime(Duration.ZERO);
        player.setOnEndOfMedia(() -> {player.seek(Duration.ZERO); player.play();});
        player.setOnPaused(() -> {
            System.out.println(player.getStatus().toString());
            /*if (!isFirstTimePlayed) {
                semaphore.release();
            } else {
                BARRIER.countDown();
            }*/

            semaphore.release();
            /*try {
                long v = ((long) ((Math.random() + 1) * 1000) * 2);
                System.out.println("Player paused for " + String.valueOf(v) + " ms");
                TimeUnit.MILLISECONDS.sleep(v);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        });
        player.setOnPlaying(() -> {
            try {
                long v = 3000 + ((long) ((Math.random() + 1) * 1000) * 4);
                System.out.println("Player playing for " +  String.valueOf(v) + " ms");
                TimeUnit.MILLISECONDS.sleep(v);
                player.pause();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        player.play();
        BARRIER.countDown();
    }
}
