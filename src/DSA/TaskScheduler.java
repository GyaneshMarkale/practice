package DSA;

import java.util.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

class Tuple
{
    int x;
    int y;
    Tuple (int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class TaskScheduler {
    public static void main(String[] args)
    {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(tasks, 2));
    }
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());

        Queue<Tuple> q = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int cnt = pq.poll() - 1;

                if (cnt != 0) {
                    q.offer(new Tuple(cnt, time + n));
                }
            }

            if (!q.isEmpty() && q.peek().y == time) {
                pq.offer(q.poll().x);
            }
        }

        return time;
    }
}
