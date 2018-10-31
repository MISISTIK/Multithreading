package ua.itea;

import java.util.concurrent.TimeUnit;

public class StringSource {
    public void printString(String s) {
        System.out.print("[ " + s);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(" ]");
    }
}
