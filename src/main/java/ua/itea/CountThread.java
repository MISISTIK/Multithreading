package ua.itea;

import java.util.concurrent.TimeUnit;

public class CountThread extends Thread {

    private long i = 0;
    private boolean pause = false;
    private boolean stopped = false;


    public CountThread() {
        this.start();
    }

    void pause() {
        System.out.println("Thread paused");
        this.pause = true;
    }

    void resumeThis() {
        synchronized (this) {
            System.out.println("Thread resumed");
            notify();
        }
        this.pause = false;
    }

    void stopThis() {
        synchronized (this) {
            System.out.println("Thread stopped");
            this.stopped = true;
            interrupt();
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            while (!stopped) {
                try {
                    if (pause) {
                        wait();
                    }
                    System.out.println(i++);

                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

