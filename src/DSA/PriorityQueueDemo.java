package DSA;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args)
    {
        int[] arr1 = {1,2,4,5,6};
        int[] arr2 = {3,5,7,9};
        int k = 5;
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.add(new int[] {arr1[0] + arr2[0], 0, 0});
        while (k > 0 && !pq.isEmpty())
        {
            int[] arr = pq.peek();
            pq.poll();
            int i = arr[1];
            int j = arr[2];
            res.add(new ArrayList<>(Arrays.asList(arr1[i], arr2[j])));
            if (i < arr1.length-1)
            {
                pq.add(new int[]{arr1[i+1] + arr2[j], i+1, j});
            }
            if (j < arr2.length-1)
            {
                pq.add(new int[]{arr1[i] + arr2[j+1], i, j+1});
            }
            k--;
        }
        System.out.println(res);
    }
}
