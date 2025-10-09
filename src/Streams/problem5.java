package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class problem4 {
    public static void main(String[] args) {
        // Convert all in lower case
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        List<String> res1 = people.stream().map(String::toLowerCase).sorted(Comparator.reverseOrder()).toList();
        System.out.println(res1);
        List<String> res2 = people.stream().map(String::toUpperCase).filter(s->s.startsWith("S")).sorted().toList();
        System.out.println(res2);
    }


}
