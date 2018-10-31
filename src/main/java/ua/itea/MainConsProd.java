package ua.itea;

public class MainConsProd {
    public static void main(String[] args) {
        Q q = new Q();
        Producer prod = new Producer(q);
        Consumer cons = new Consumer(q);
    }
}
