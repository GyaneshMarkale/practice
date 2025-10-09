package JAVA8;

import java.util.*;

class Pair {
    int first;
    String second; // Or whatever type your second value is

    public Pair(int first, String second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    // You might want to implement equals() and hashCode() for Pair as well
}
public class TreeMapCompareDemo {
    static Map<Integer, Pair> map;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) {
        map = new HashMap<>();
        pq = new PriorityQueue<>((k1, k2) -> {
            Pair p1 = map.get(k1);
            int v1 = p1.getFirst();
            Pair p2 = map.get(k2);
            int v2 = p2.getFirst();
            return v2 - v1;

        });

        // Add elements to the map
        map.put(1, new Pair(5, "Apple"));
        pq.add(1);
        map.put(2, new Pair(2, "Banana"));
        pq.add(2);
        map.put(3, new Pair(8, "Cherry"));
        pq.add(3);
        map.put(4, new Pair(2, "Date")); // Example with same 'first' value

        // Print the sorted map
        System.out.println(map);
        while (!pq.isEmpty())
        {
            System.out.println(pq.poll());
        }
    }
}
