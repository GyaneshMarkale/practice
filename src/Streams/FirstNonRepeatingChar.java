package Streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
    public static void main(String[] args)
    {
        String s = "abaccd";
        Character ch = s.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(m -> m.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println(ch);
    }
}
