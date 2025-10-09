package Multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DeadLockScenerio {
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    public static void main(String[] args)
    {
        Thread t1 = new Thread(() -> {
            try {
                if (lock1.tryLock(500, TimeUnit.MILLISECONDS)) {
                    System.out.println("Thread-1: holding lock1...");
                    try {
                        Thread.sleep(100);
                    } catch (Exception ex) {
                    }
                    if (lock2.tryLock()) {
                        System.out.println("Thread-1: holding lock2");
                    } else {
                        System.out.println("Thread-1 could not acquire lock2, avoiding deadlock!");
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("");
            }
        });

        Thread t2 = new Thread(() -> {
            if (lock2.tryLock()) {
                System.out.println("Thread-2: holding lock2...");
                try {
                    Thread.sleep(50);
                } catch (Exception ignored) {}
                if (lock1.tryLock()) {
                    System.out.println("Thread-2: holding lock1...");
                }
                else
                {
                    System.out.println("Thread-2 could not acquire lock1, avoiding deadlock!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
