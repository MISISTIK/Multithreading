package ua.itea;

import java.util.concurrent.Semaphore;

public class SemaphoreWorker implements Runnable {

    String name;
    Semaphore s;

    public SemaphoreWorker(String name, Semaphore s) {
        this.name = name;
        this.s = s;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Thread + " + name + " started");
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " " + ++Shared.c);
        }
        s.release();
    }
}
