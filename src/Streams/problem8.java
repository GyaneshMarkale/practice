package Streams;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class problem8 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        IntStream.range(0, arr.length)
                .mapToDouble(i -> Arrays.stream(arr, 0, i+1)
                        .average().orElse(0.0)).forEach(System.out::println);
        //Arrays.stream(arr).max().getAsInt()
    }
}
