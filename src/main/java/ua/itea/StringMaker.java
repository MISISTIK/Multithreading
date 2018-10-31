package ua.itea;

public class StringMaker implements Runnable {

    private StringSource ss;
    private String msg;
    private Thread th;

    public Thread getTh() {
        return th;
    }

    public StringMaker(StringSource ss, String msg) {
        this.ss = ss;
        this.msg = msg;
        th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        synchronized (ss) {
            ss.printString(msg);
        }
    }
}
