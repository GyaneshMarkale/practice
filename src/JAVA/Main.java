package JAVA;
interface Demo {
    void divide(int a, int b) throws ArithmeticException;
}
class ExceptionDemo {
    public void divide(int a, int b) throws Exception{
        int res = a/b;
        System.out.println(res);
    }
}

public class Main{
    public static void main(String[] agrs) throws Exception
    {
        ExceptionDemo ed = new ExceptionDemo();
        ed.divide(10, 0);
//        try
//        {
//            ed.divide(10, 0);
//        }
//        catch (ArithmeticException e)
//        {
//            System.out.println(e);
//        }

    }
}
