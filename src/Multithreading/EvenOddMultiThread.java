package Multithreading;

import com.sun.jdi.ThreadGroupReference;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EvenOddMultiThread {
    private static ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();
    private static int CURRENT = 1;
    private static final int MAX_ELEMENT = 50;
    public static void main (String [] args)
    {
        Thread t1 = new Thread(() -> {
           while (CURRENT <= MAX_ELEMENT)
           {
               synchronized (LOCK)
               {
                   if(CURRENT % 2 == 0)
                   {
                       Thread.currentThread().setName("evenThread");
                       System.out.println(CURRENT+": "+Thread.currentThread().getName());
                       CURRENT++;
                       LOCK.notify();
                   }
                   else
                   {
                       try
                       {
                           LOCK.wait();
                       }
                       catch (InterruptedException ex)
                       {
                           System.out.println("Something went wrong "+ex);
                       }
                   }
               }
           }
        });

        Thread t2 = new Thread(() -> {
           while (CURRENT <= MAX_ELEMENT)
           {
               synchronized (LOCK) {
                   if (CURRENT % 2 == 1) {
                       Thread.currentThread().setName("oddThread");
                       System.out.println(CURRENT + ": " + Thread.currentThread().getName());
                       CURRENT++;
                       LOCK.notify();
                   } else {
                       try {
                           LOCK.wait();
                       } catch (InterruptedException ex) {
                           System.out.println(ex);
                       }
                   }
               }
           }
        });
        t1.start();
        t2.start();

    }
}
