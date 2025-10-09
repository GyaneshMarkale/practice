package Streams;

import java.util.List;

public class sumOfSquaresOfEven {
    public static void main(String[] args)
    {
        List<Integer> list = List.of(1, 2, 3, 4);
        int sum = list.stream().filter(x -> x % 2 == 0).map(x -> x * x).reduce(Integer::sum).get();
        System.out.println(sum);
    }
}
