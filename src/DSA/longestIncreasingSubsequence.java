package DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class longestIncreasingSubsequence {
    public static void main(String[] args)
    {
        int[] arr = {1, 7, 8, 4, 5, 6, -2, 9};
        System.out.println(calLis(arr));
    }

    private static int calLis(int[] nums)
    {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for(int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                int index = Collections.binarySearch(temp, nums[i]);
                if (index < 0) {
                    index = -index - 1;
                }
                temp.set(index, nums[i]);
            }
        }
        return temp.size();
    }
}
