package ua.itea;


public class Multithreading
{
    public static void main( String[] args )
    {
        /*
        MyThread mt = new MyThread();
        mt.getThread().start();
        System.out.println( Thread.activeCount() );
        */

        new SecThread("1",10);
        new SecThread("2",1);
    }
}
