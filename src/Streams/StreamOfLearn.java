package Streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfLearn {
    public static void main(String[] args)
    {
        String[] names = {"Alice", "Bob", "Charlie"};
        Stream<String> nameStream = Stream.of(names);
        nameStream.forEach(System.out::println); // reference type will out stream of strings, accessing each element

        int[] numbers = {1, 2, 3};
        Stream<int[]> intArrayStream = Stream.of(numbers);
        intArrayStream.forEach(arr -> System.out.println(Arrays.toString(arr)));  // take it single element being primitive

        int[] nums = {1, 2, 3};
        IntStream intStream = Arrays.stream(numbers);
        intStream.forEach(System.out::println);

        Stream.of(1, 2, 3)
                .peek(n -> System.out.println("Value: " + n))
                .map(n -> n * 10)
                .forEach(System.out::println);
    }
}
