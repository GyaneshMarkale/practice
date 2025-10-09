package Multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private static int COUNT = 0;
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String [] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                doubleIncrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                doubleIncrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
    public static void increment() throws InterruptedException {
        COUNT++;
        Thread.sleep(100);
//        lock.lock();
//        try {
//            System.out.println("inside increment");
//            COUNT++;
//        }
//        finally {
//            lock.unlock();
//        }

    }
    public static void doubleIncrement() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("inside DoubleIncrement");
            increment();
            increment();
            System.out.println(COUNT);
        }
        finally {
            lock.unlock();
        }
    }
}
