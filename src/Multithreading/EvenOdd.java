package Multithreading;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//public class EvenOdd {
//    private static final Object lock = new Object();
//    private static int current = 1;
//    private static final int maxNumber = 10;
//
//    public static void main(String[] args)
//    {
//        Thread t1 = new Thread(() -> {
//            while (current <= maxNumber)
//            {
//                synchronized (lock)
//                {
//                    if (current % 2 == 0) {
//                        Thread.currentThread().setName(" Thread-even");
//                        System.out.println(current + Thread.currentThread().getName());
//                        current++;
//                        lock.notify();
//                    }
//                    else
//                    {
//                        try{
//                            lock.wait();
//                        }
//                        catch (InterruptedException e)
//                        {
//                            Thread.currentThread().interrupt();
//                        }
//                    }
//                }
//            }
//        });
//        Thread t2 = new Thread(() ->{
//           while (current <= maxNumber)
//           {
//               synchronized (lock)
//               {
//                   if (current % 2 != 0)
//                   {
//                       Thread.currentThread().setName("Thread-odd");
//                       System.out.println(current+Thread.currentThread().getName());
//                       current++;
//                       lock.notify();
//                   }
//                   else
//                   {
//                       try {
//                           lock.wait();
//                       }
//                       catch (InterruptedException e)
//                       {
//                           Thread.currentThread().interrupt();
//                       }
//                   }
//               }
//           }
//        });
//        t1.start();
//        t2.start();
//    }
//}

public class EvenOdd {
    public static final ReentrantLock LOCK = new ReentrantLock();
    public static int CURRENT = 1;
    public static final int MAX_NUMBER = 50;
    public static void main(String[] args)
    {
        Thread t1 = new Thread(() -> {
                while (CURRENT <= MAX_NUMBER) {
                    synchronized (LOCK) {
                        if (CURRENT % 2 == 0) {
                            Thread.currentThread().setName("evenThread");
                            System.out.println(Thread.currentThread().getName() + " :" + CURRENT);
                            CURRENT++;
                            LOCK.notify();
                        } else {
                            try {
                                LOCK.wait();
                            } catch (Exception ex) {
                                Thread.currentThread().interrupt();
                            }
                        }

                    }
                }
            });
            Thread t2 = new Thread(() -> {
                while (CURRENT < MAX_NUMBER) {
                    synchronized (LOCK) {
                        if (CURRENT % 2 != 0) {
                            Thread.currentThread().setName("odd-Thread");
                            System.out.println(Thread.currentThread().getName() + " :" + CURRENT);
                            CURRENT++;
                            LOCK.notify();
                        } else {
                            try {
                                LOCK.wait();
                            } catch (Exception ex) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
            });
            t1.start();
            t2.start();
    }
}
