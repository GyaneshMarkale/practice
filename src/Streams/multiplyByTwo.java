package Streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class multiplyByTwo {
    public static void main(String[] args)
    {
        String s = "abbcca";
//        int[] array = {1,4,5,7,3,6};
//        List<Integer> list = Arrays.stream(array).mapToObj(ele -> ele * 2)
//                .collect(Collectors.toList());
//        System.out.println(list);

//        Optional<Character> ch = s.chars().mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(ele ->ele, LinkedHashMap::new, Collectors.counting()))
//                .entrySet().stream().filter(m -> m.getValue() > 1)
//                .map(Map.Entry::getKey).findFirst();
        Set<Character> seen = new HashSet<>();
        Optional<Character> ch = s.chars().mapToObj(c -> (char) c)
                        .filter(c -> !seen.add(c))
                                .findFirst();
        System.out.println(ch.get());
    }
}
