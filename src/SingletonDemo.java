import javax.sound.sampled.FloatControl;
import java.util.Currency;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonDemo {
    public static ReentrantLock lock = new ReentrantLock();
    private static int CURRENT = 1;
    private static final int MAX_NUMBER = 10;
    public static void main(String[] args)
    {
        Thread t1 = new Thread(() -> {
            while (CURRENT <= MAX_NUMBER) {
                synchronized (lock) {
                    while (CURRENT <= MAX_NUMBER) {
                        if (CURRENT % 2 != 0) {
                            Thread.currentThread().setName("ODD-Thread");
                            System.out.println("number: " + CURRENT + " " + Thread.currentThread().getName());
                            CURRENT++;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                try {
                                    throw new InterruptedException();
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                    }
                }
            }

        });

        Thread t2 = new Thread(() -> {
            while (CURRENT <= MAX_NUMBER) {
                synchronized (lock) {
                    while (CURRENT <= MAX_NUMBER) {
                        if (CURRENT % 2 == 0) {
                            Thread.currentThread().setName("EVEN-Thread");
                            System.out.println("number: " + CURRENT + " " + Thread.currentThread().getName());
                            CURRENT++;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                try {
                                    throw new InterruptedException();
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                    }
                }
            }

        });
        t1.start();
        t2.start();
    }
}
