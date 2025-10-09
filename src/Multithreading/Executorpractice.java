package Multithreading;

import java.util.concurrent.*;

public class Executorpractice {
    public static void main(String[] args) {
        //int numberOfThreads = 10;
        int numberOfThreads = Runtime.getRuntime().availableProcessors();// via number of cores
        System.out.println("number of cores available: "+numberOfThreads);

        ExecutorService es = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < 100; i++) {
            es.submit(new Task());
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
