package DSA;

import java.util.*;
import java.util.stream.Collectors;

public class findMostFreqIPAddress {

    public static void main(String[] args)
    {
        String[] logs = {"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-23", "10.0.0.2 - GET 2020-08-20",
                "10.0.0.2 - GET 2020-08-21", "10.0.0.3 - GET 2020-08-24"};
        findMostFreqIp(logs);

//        String s = "AAnbcc";
//        Character ch = s.chars().mapToObj(c -> (char) c)
//                .collect(Collectors
//                        .groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting()))
//                .entrySet().stream().filter(k -> k.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
//        System.out.println(ch);

    }

    public static void findMostFreqIp(String[] logs) {
        //String[] res = new String[];
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < logs.length; i++)
        {
            //String s = logs[i].substring(0, 9);
            String s = logs[i].split(" ")[0];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);
        int maxValue = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue((a, b)-> b-a))
                .filter(m -> m.getValue() == maxValue)
                .forEach(k -> System.out.println(k.getKey()));
    }
}
