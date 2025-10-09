package JAVA8;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] agrs)
    {
        String s = "";
        System.out.println(s.isEmpty());
        System.out.println(isEven(100));
        System.out.println(isEven(101));
    }

    public static boolean isEven(int num)
    {
        Predicate<Integer> predicate = x -> x % 2 == 0;
        return predicate.test(num);
    }
}
