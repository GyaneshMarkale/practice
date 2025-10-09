package Streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class problem14 {
    public static void main(String[] args)
    {
        String[][] namesArray = {
                {"Aaron", "Abby", "Alan", "Aaarya"},
                {"Aanya", "Aaiden", "Chris", "Aaron"},
                {"AaRonald", "Alex", "Aaarya", "Chris"}
        };
        Arrays.stream(namesArray).flatMap(Arrays::stream).collect(Collectors.groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(m -> System.out.println(m.getKey()+" "+m.getValue()));
    }
}
