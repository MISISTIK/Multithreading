package ua.itea;

public class Producer extends Thread {
    Q q = new Q();

    public Producer(Q q) {
        this.q = q;
        start();
    }

    @Override
    public void run() {
        int temp = 0;
        while (true) {
            try {
                q.putX((int) (Math.random() * 4));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
