package Multithreading;
import java.util.concurrent.*;
import java.util.function.BiFunction;
public class CompletableFuture {
    public static void sleep(int millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void executionThread()
    {
        System.out.println("Thread name: "+ Thread.currentThread().getName());
    }

    public static void main(String[] args)
    {
        java.util.concurrent.CompletableFuture<String> future1 = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            String s1 = "Test1";
            System.out.println("async first execution: "+s1);
            executionThread();
            return s1;
        });

        java.util.concurrent.CompletableFuture<String> future2 = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
           sleep(1000);
           String s2 = "Test2";
           System.out.println("Second Async execution: "+s2);
           executionThread();
           return s2;
        });

        BiFunction<String, String, String> stringStringBiFunction =
                (res1, res2) -> String.format("\"completableFuture1 result - %s | completableFuture2 result - %s\"", res1, res2);
        java.util.concurrent.CompletableFuture<String> finalCompletablefuture = future1.thenCombine(future2, stringStringBiFunction);
        System.out.println("final answer: "+finalCompletablefuture);
    }
}
