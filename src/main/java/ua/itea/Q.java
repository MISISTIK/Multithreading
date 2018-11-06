package ua.itea;

import java.util.concurrent.Semaphore;


public class Q {
    private int x = 0;
    Semaphore p = new Semaphore(0);
    Semaphore c = new Semaphore(1);

    volatile boolean check = true;

    public Q() {

    }


    synchronized int getX() throws InterruptedException {
        p.acquire();
        /*while (check) {
            System.out.println("Consumer Waiting");
            try {
                semaphore.acquire();
                check = !check;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        int temp = this.x;
        System.out.println("Consumed " + String.valueOf(temp));
        this.x = 0;
//        notify();
//        semaphore.release();
        c.release();
        return temp;
    }

    synchronized void putX(int x) throws InterruptedException {
        c.acquire();
//        while (!check) {
//            System.out.println("Producer Waiting");
//            check = !check;
//        }

        this.x += x;
        System.out.println("Produced " + String.valueOf(x));

       // notify();
//        semaphore.release();
        p.release();
    }
}

