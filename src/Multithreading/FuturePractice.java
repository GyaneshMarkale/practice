package Multithreading;

import java.util.Iterator;
import java.util.concurrent.*;

public class FuturePractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<Integer> f = null;
        for (int i = 0; i < 15; i++) {
            f = service.submit(new Task1());
            System.out.println("some process");
            
        }
        Integer futureValue = f.get();  // blocking
        System.out.println("future value: "+futureValue);

    }

}

class Task1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return 3;
    }
}
