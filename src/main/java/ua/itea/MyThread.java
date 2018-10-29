package ua.itea;

public class MyThread extends Thread {

    private Thread thread;

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public MyThread() {
        thread = new Thread(this);
    }

    @Override
    public void run() {
        System.out.println("New Thread");
    }
}
