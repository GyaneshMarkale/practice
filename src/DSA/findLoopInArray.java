package DSA;

import java.sql.Struct;

public class findLoopInArray {
    public static void main (String[] args)
    {
        int arr[] = {1, 0};
        int len = findcycle(arr, 0);
        System.out.println(len);
    }

    private static int findcycle(int[] arr, int startIndex) {
        int n = arr.length;
        int slow = startIndex;
        int fast = startIndex;
        int loop = 0;
        while (fast >= 0 && fast < n && arr[fast] >= 0 && arr[fast] < n)
        {
            slow = arr[slow];
            fast = arr[arr[fast]];
            loop++;
            if (slow == fast)
            {
                return loop;
            }

        }
        return -1;
    }
}
