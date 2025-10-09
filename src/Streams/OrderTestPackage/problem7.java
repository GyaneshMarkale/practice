package Streams.OrderTestPackage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class problem7 {
    // sum of all odd numbers
    public static void main (String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Optional<Integer> sumOfOddNum = list.stream()
                .filter(x -> x % 2 == 1)
                .map(x -> x * x)
                .reduce(Integer::sum);
        System.out.println(sumOfOddNum);
        System.out.println(sumOfOddNum.get());
    }

}
