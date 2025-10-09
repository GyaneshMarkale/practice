package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class problem6 {
    public static void main(String[] args)
    {
        int[] Array1 = {13, 12, 11, 6, 9, 3 };
        int[] Array2  = {78, 34, 56, 67, 2, 11, 7 };

        //using concat
        List<Integer> list = Stream.concat(
                Arrays.stream(Array1).boxed(),
                Arrays.stream(Array2).boxed())
                .sorted()
                .toList();
        System.out.println(list);

        //using flatmap
        int[] arr = Stream.of(Array1, Array2)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .toArray();

        System.out.println(Arrays.toString(arr));
    }
}
