package Streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class problem13 {
    public static void main(String[] args)
    {
        String[][] namesArray = {
                {"Aaron", "Abby", "Alan", "Aaarya"},
                {"Aanya", "Aaiden", "Chris", "Aaron"},
                {"AaRonald", "Alex", "Aaarya", "Chris"}
        };
        Arrays.stream(namesArray).flatMap(Arrays::stream).filter(ele -> ele.startsWith("Aa"))
                .distinct().forEach(System.out::println);
    }
}
