package Streams;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class problem5 {
    public static void main(String[] args) {
        //maximum value
        List<Integer> numbers = Arrays.asList(2, 4, 8, 6, 10);
        int maxValue = numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(maxValue);

        // other way

        int maxi = numbers.stream().mapToInt(Integer::valueOf).max().getAsInt();
        System.out.println(maxi);
    }


}
