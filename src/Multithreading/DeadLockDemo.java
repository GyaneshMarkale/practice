package Multithreading;

class Resource {
    String name;
    Resource(String s)
    {
        this.name = s;
    }
    public String getName()
    {
        return name;
    }
}
public class DeadLockDemo {
    public static void main(String[] args)
    {
        Resource lock1 = new Resource("lock1");
        Resource lock2 = new Resource("lock2");
        Thread t1 = new Thread(() ->{
           synchronized (lock1)
           {
               System.out.println("Thread 1 holding: " +lock1.getName());
               try
               {
                   Thread.sleep(100);
               }
               catch (Exception ex)
               {
                   Thread.currentThread().interrupt();
               }
               synchronized (lock2)
               {
                   System.out.println("Thread 1 holding:" +lock2.getName());
               }
           }
        });
        Thread t2 = new Thread(() ->{
            synchronized (lock2)
            {
                System.out.println("Thread 2 holding: " +lock2.getName());
                try
                {
                    Thread.sleep(100);
                }
                catch (Exception ex)
                {
                    Thread.currentThread().interrupt();
                }
                synchronized (lock1)
                {
                    System.out.println("Thread 2 holding:" +lock1.getName());
                }
            }
        });
        t1.start();
        t2.start();
    }
}
