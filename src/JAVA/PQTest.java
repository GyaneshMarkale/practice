package JAVA;

import java.util.PriorityQueue;

public class PQTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        max.add(1);
        max.add(2);
        min.add(1);
        min.add(2);

        int i = 1;
        while (!max.isEmpty())
        {
            System.out.println("From max "+i+": "+max.poll());
            System.out.println("From min "+i+": "+min.poll());
            i++;
        }
    }
}
