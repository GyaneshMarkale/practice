package Multithreading;

import java.util.Random;
import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<Integer> future = es.submit(new Task());
        System.out.println("Thread :" + Thread.currentThread().getName());
        int res = future.get(); // block the thread until it executed\
        System.out.println("future value: "+res);
        for (int i = 0; i < 10; i++)
        {
            System.out.println(i);

        }
        //int res = future.get();
        System.out.println("future value: "+res);
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(10000);
            return new Random().nextInt();
        }
    }
}
