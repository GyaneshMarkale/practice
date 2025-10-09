package Multithreading;

public class ThreadLocalDemo1 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);
    public static void main (String[] args) {
        Runnable task = () -> {
            try {
                int value = threadLocal.get();
                threadLocal.set(value + 1);
                System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            } finally {
                threadLocal.remove();
                System.out.println("ThreadLocal remove finished: "+threadLocal.get());
            }
        };
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        t1.start();
        t2.start();
    }
}
