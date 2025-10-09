package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class problem12 {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        String s = listOfStrings.stream().collect(Collectors.groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
        System.out.println(s);


    }
}