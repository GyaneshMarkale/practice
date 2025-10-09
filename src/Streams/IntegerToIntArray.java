package Streams;

import java.util.*;

public class IntegerToIntArray {
    public static void main(String[] args)
    {
        int num = 12345;
        // using streams
        Arrays.stream(new StringBuilder(String.valueOf(num))
                .reverse().chars().map(c -> c - '0').toArray()).forEach(System.out::print);
    }

//    public static int[] solve(int num)
//    {
//        List<Integer> res = new ArrayList<>();
//        while (num > 9)
//        {
//            res.add(num/10);
//        }
//        res.add(num % 10);
//        Collections.reverse(res);
//        return res.toArray(new int[res.size()][]);
//    }

}
