package JAVA;
interface Demo {
    void divide(int a, int b) throws Exception;
}
class ExceptionDemo implements Demo{
    @Override
    public void divide(int a, int b) {
        int res = a/b;
        System.out.println(res);
    }
}

public class Main{
    public static void main(String[] agrs)
}
