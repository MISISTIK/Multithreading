package ua.itea;

import java.util.concurrent.Semaphore;

public class SM {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);
        new SemaphoreWorker("A", s);
        new SemaphoreWorker("B", s);
        new SemaphoreWorker("C", s);
    }
}
