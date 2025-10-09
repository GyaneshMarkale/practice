package Streams.OrderTestPackage;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main (String[] args)
    {
//        List<Integer> list = Arrays.asList(1,2,2,3,4,8,11,4);
//        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(ele -> ele,Collectors.counting()));
//        System.out.println(map);

        String s1 = "geeksforgeeks";
        LinkedHashMap<Character, Long> m = s1.chars().mapToObj(c-> (char)c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
        System.out.println(m);
        TreeMap<Character, Long> m1 = s1.chars().mapToObj(c-> (char)c)
                .collect(Collectors.groupingBy(c -> c, TreeMap::new, Collectors.counting()));
        System.out.println(m1);
    }


}
