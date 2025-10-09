package Streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class problem10 {
    public static void main (String[] args)
    {
        String s = "aappletty";
        Character res = s.chars().mapToObj(c ->(char) c)
                .collect(Collectors.groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(m -> m.getValue() == 1).map(Map.Entry::getKey).limit(3).skip(2).findFirst()
                .orElse(null);
        System.out.println(res);
    }
}
