package ua.itea;


public class Multithreading
{
    public static void main( String[] args ) throws InterruptedException {
        /*
        MyThread mt = new MyThread();
        mt.getThread().start();
        System.out.println( Thread.activeCount() );
        */
        ManThread th1 = new ManThread("First ");
        ManThread th2 = new ManThread("Second");
        Thread.sleep(1000);

        while (th2.isAlive() && th1.isAlive()) {}
        if (!th1.isAlive()) {
            System.out.println(th1.getPlayerName() + " wins");
        } else {
            System.out.println(th2.getPlayerName() + " wins");
        }

    }
}
