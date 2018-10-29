package ua.itea;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ManThread extends Thread {
    private String name;
    private String way;

    public String getPlayerName() {
        return this.name;
    }

    public ManThread(String name) {
        this.name = name;
        this.way = "";
        start();
    }

    @Override
    public void run() {
        while (this.way.length() <= 20) {
            char[] charArray = new char[(int)(Math.random() * 3) + 1];
            Arrays.fill(charArray, '-');
            this.way += new String(charArray);
            System.out.println(this.name + " = " + this.way);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
