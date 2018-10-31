package ua.itea;

import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {
    Q q = new Q();

    int cons_x = 0;

    public Consumer(Q q) {
        this.q = q;
        start();
    }


    @Override
    public void run() {
        while (true) {
            this.cons_x += q.getX();
        }
    }
}
