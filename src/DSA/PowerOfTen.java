package DSA;

public class PowerOfTen {
    public static void main(String [] args)
    {
        System.out.println(isPower(10));
        System.out.println(isPower(100));
        System.out.println(isPower(3));
        System.out.println(isPower(1));

    }

    public static boolean isPower(int num)
    {
        if (num == 1 || num == 0) return false;
       while (num / 10 != 1)
       {
           if (num % 10 != 0) return false;
           num = num / 10;
       }
       return true;
    }
}
