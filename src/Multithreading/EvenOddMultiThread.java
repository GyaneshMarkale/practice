package Multithreading;

public class EvenOddMultiThread {
    private static final Object lock = new Object();
    private static int current = 1;
    private static final int maxNumber = 50;

    public static void main(String args[])
    {
        Thread t1 = new Thread(() -> {
            while (current <= maxNumber)
            {
                synchronized (lock)
                {
                    if (current % 2 == 0)
                    {
                        System.out.print(" "+current);
                        current++;
                        lock.notify();
                    }
                    else {
                        try
                        {
                            lock.wait();
                        }
                        catch (InterruptedException e)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (current <= maxNumber)
            {
                synchronized (lock)
                {
                    if (current % 2 != 0)
                    {
                        System.out.print(" "+current);
                        current++;
                        lock.notify();
                    }
                    else {
                        try
                        {
                            lock.wait();
                        }
                        catch (InterruptedException e)
                        {
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
