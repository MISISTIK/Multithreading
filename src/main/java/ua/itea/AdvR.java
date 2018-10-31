package ua.itea;

public class AdvR {
    public static void main(String[] args) {
        CountThread th1 = new CountThread();

        try {

            Thread.sleep(2500);

            th1.pause();

            Thread.sleep(3000);

            th1.resumeThis();

            Thread.sleep(3000);

            th1.stopThis();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
