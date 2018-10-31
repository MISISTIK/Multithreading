package ua.itea;

public class Q {
    private int x = 0;

    volatile boolean check = true;

    public Q() {

    }


    synchronized int getX() {
        while (check) {
            System.out.println("Consumer Waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int temp = this.x;
        System.out.println("Consumed " + String.valueOf(temp));
        this.x = 0;
        check = !check;
        notify();
        return temp;
    }

    synchronized void putX(int x) throws InterruptedException {
        while (!check) {
            System.out.println("Producer Waiting");
            wait();
        }
        this.x += x;
        System.out.println("Produced " + String.valueOf(x));
        check = !check;
        notify();
    }
}

