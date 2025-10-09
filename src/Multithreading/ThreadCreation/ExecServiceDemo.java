package Multithreading.ThreadCreation;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> result = es.submit(() -> {
            System.out.println("Running Future with es: " +Thread.currentThread().getName());
            Thread.sleep(1000);
            return 42;
        });

        int out = result.get(); // blocks until result is available
        System.out.println(out);
        es.shutdown();

    }
}
