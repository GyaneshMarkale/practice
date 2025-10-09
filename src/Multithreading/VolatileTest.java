package Multithreading;

public class VolatileTest {
    boolean flag1 = true;
    volatile boolean flag2 = true;

    public void writer()
    {
        flag1 = false;
        System.out.println("Writer:" +flag1);
    }

    public void reader()
    {
        System.out.println("reader:" + flag1);
        if (flag1) {
            System.out.println("reader:" + flag1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest vt = new VolatileTest();
        Thread t1 = new Thread(vt::writer);
        Thread t2 = new Thread(vt::reader);
        t1.start();
        Thread.sleep(100);
        t2.start();

    }
}
