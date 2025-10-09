package DSA;

import java.util.Arrays;
import java.util.Comparator;

public class add1 {
    public static void main (String[] args)
    {
        int[] arr = {3, 34, 4, 12, 5, 2};
        boolean res =  subsetSumToK(arr, 9);
        System.out.println(res);
    }

    static boolean subsetSumToK(int[] arr, int k) {
        int n = arr.length;
        // Create a boolean DP table with dimensions [n][k+1]
        boolean dp[][] = new boolean[n][k + 1];

        // Initialize the first row of the DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current element
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Store the result in the DP table
                dp[ind][target] = notTaken || taken;
            }
        }

        // The final result is stored in the bottom-right cell of the DP table
        return dp[n - 1][k];
    }
}
