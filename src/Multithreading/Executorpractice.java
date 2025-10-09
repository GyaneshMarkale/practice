package Multithreading;

import java.util.concurrent.*;

public class Executorpractice {
    public static void main(String[] args) {
        //int numberOfThreads = 10;
        int numberOfThreads = Runtime.getRuntime().availableProcessors();// via number of cores
        System.out.println("number of cores available: "+numberOfThreads);

        //ExecutorService es = Executors.newFixedThreadPool(numberOfThreads);
        //ExecutorService es = Executors.newCachedThreadPool();
        ScheduledThreadPoolExecutor es = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);


        for (int i = 0; i < 100; i++) {
            es.scheduleWithFixedDelay(new Task(), 14,10, TimeUnit.SECONDS);
        }
        es.shutdown();
        if (es.isShutdown())
        {
            try
            {
                System.out.println("Service is shutdown");
            }
            catch (RejectedExecutionException e)
            {
                System.out.println("Rejection");
            }
            for (int i = 0; i < 100; i++) {
                es.submit(new Task());
            }
        }
    }
}
class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread Name: "+Thread.currentThread().getName());
    }
}
