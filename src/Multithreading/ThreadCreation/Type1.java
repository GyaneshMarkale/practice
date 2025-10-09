package Multithreading.ThreadCreation;

public class Type1 {
    public static void main(String[] args)
    {
        Thread t1 = new MyThread();
        Thread t2 = new Thread(new MyTask());
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {
    public void run()
    {
        System.out.println("Running Thread class thread: "+Thread.currentThread().getName());
    }
}

class MyTask implements Runnable{

    @Override
    public void run() {
        System.out.println("Running Runnable Thread: "+Thread.currentThread().getName());
    }
}
