package ua.itea;

public class MainConsProd {
    public static void main(String[] args) throws InterruptedException {
        Q q = new Q();
        Producer prod = new Producer(q);
        Consumer cons = new Consumer(q);

    }
}
