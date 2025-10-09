package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockPractice {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    List<Integer> list = new ArrayList<>();

    public void read() {
        for (int i : list) {
            System.out.println("output: " + i);
        }
    }

    public void write(int num)
    {
        list.add(num);
        System.out.println("added number in list: "+ num);
    }
    public static void main(String[] args) throws InterruptedException {
        LockPractice obj = new LockPractice();
        Random ran = new Random();
        Thread t1 = new Thread(() -> obj.read()); t1.start();
        Thread t3 = new Thread(() -> obj.read()); t3.start();
        Thread t2 = new Thread(() -> obj.write(ran.nextInt())); t2.start();
        Thread.sleep(3000);
        Thread t4 = new Thread(() -> obj.write(ran.nextInt())); t4.start();
        Thread.sleep(3000);
        Thread t6 = new Thread(() -> obj.read()); t6.start();
        Thread t5 = new Thread(() -> obj.read()); t5.start();

        System.out.println("task finished....");
    }
}
