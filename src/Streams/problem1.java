package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class problem1 {
    // print all the letter starts with S and sort according to there length

    public static void main (String[] args)
    {
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};

        Arrays.stream(names).filter(word -> word.startsWith("S")).sorted(Comparator.reverseOrder()).forEach(System.out::println);


//        Arrays.stream(names).filter(s->s.startsWith("S")).sorted().forEach(s->System.out.println(s));
        // sorted in descending
//        Arrays.stream(names).filter(s -> s.startsWith("A")).sorted(Comparator.reverseOrder()).forEach(s->System.out.println(s));
//        Arrays.stream(names).sorted(Comparator.reverseOrder()).limit(1).;
        //Arrays.stream(names).sorted().forEach(ele -> System.out.println(ele));
//        String out = Arrays.stream(names).max(Comparator.comparing(String::length)).get();
//        int charCount = (int) out.chars().count();
//        System.out.println(out);
//        System.out.println(charCount);
//
//        List<Integer> listOfNum = Arrays.asList(1, 2, 3, 4, 5, 2, 7, 8, 9, 10);
//        Map.Entry<Integer, Long> a = listOfNum.stream().collect(Collectors.groupingBy(ele -> ele, Collectors.counting())).entrySet().stream()
//                .max((Comparator.comparing(Map.Entry::getValue))).get();
//        System.out.println(a.getValue());
    }
}
