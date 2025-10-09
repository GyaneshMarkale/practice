package JAVA8;

import java.util.*;

public class PriorityQueue1 {
    public static void main(String[] args)
    {
        String[] strArray = {"gyanesh","markale", "gyanesh", "gyanesh", "markale", "sehaj"};
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < strArray.length; i++) {
            map.put(strArray[i], map.getOrDefault(strArray[i], 0) + 1);

        }
        PriorityQueue<String> pq = new PriorityQueue<>(
                (key1, key2) -> {
                    int val1 =  map.get(key1);
                    int val2 =map.get(key2);
                    return val1 - val2;
                });

        for (int i = 0; i < strArray.length; i++) {
            map.put(strArray[i], map.getOrDefault(strArray[i], 0) + 1);
        }
        for (Map.Entry<String, Integer>m : map.entrySet())
        {
            pq.add(m.getKey());
            if (pq.size() > 2) pq.poll();
        }
        while (!pq.isEmpty())
        {
            System.out.println(pq.peek());
            pq.poll();
        }
    }


}
