package ua.itea;

import java.util.concurrent.TimeUnit;

public class SecThread extends Thread {
    private String name;

    @Override
    public void run() {
        for (int i = 0; i< 20; i++) {
            System.out.println(name + " : " + i);
            /*
            try {
                TimeUnit.MICROSECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
        }

    }

    public SecThread(String name, int priority) {
        this.name = name;
        setPriority(priority);
        start();
    }
}
