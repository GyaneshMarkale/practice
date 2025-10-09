package Streams;

import java.util.Arrays;
import java.util.Comparator;

public class findSmallestElement {
    public static void main(String[] args)
    {
        int[] arr = {-1, 0, 1, -2, 2};
        int mini = Arrays.stream(arr).sorted().skip(1).findFirst().getAsInt();
        System.out.println(mini);
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < smallest)
            {
                secondSmallest = smallest;
                smallest = arr[i];
            }
            else if (arr[i] > smallest && arr[i] < secondSmallest)
            {
                secondSmallest = arr[i];
            }
        }
        System.out.println(secondSmallest);
    }
}
