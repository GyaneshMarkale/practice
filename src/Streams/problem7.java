package Streams;

import Multithreading.CompletableFuture;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class problem7 {
    public static void main (String[] args)
    {
        String s = "aabbbaaa";
//        Arrays.stream(s.split("")).collect(Collectors.groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting()))
//                .forEach((k, v) -> System.out.print(k+v));
        System.out.println("");
        System.out.println(encodeChar(s));
        System.out.println("************************");
//        s.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting()))
//                        .entrySet().stream().map(m -> m.getKey()).map()
//        System.out.println("************************");

       Arrays.stream(s.split("")).collect(Collectors.groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting()))
               .forEach((k, v) -> System.out.print(k+v));
    }

    public static String encodeChar(String s)
    {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> m : map.entrySet())
        {
            sb.append(m.getKey());
            sb.append(m.getValue());
        }
        return sb.toString();
    }
}

