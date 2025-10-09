package Multithreading;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class completeableFuture2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        java.util.concurrent.CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->
        {
            try {
                Thread.sleep(5000);
                System.out.println("testing CompletebaleFuture");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";
        });
//        future1.get(); // now this will wait 5000ms, till then main thread also be blocked.
        String now = future1.getNow("A thread task is running in background"); // this will not blocked main thread (useful
        // to inform thread is working in background )
        System.out.println(now);
        System.out.println("main");
    }
}
