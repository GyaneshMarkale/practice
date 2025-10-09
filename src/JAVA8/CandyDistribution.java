package JAVA8;

/**
 * Akash wants to distribute candies on his birthday. There are A people and he has two types of candies. B candies of the first type and C candies of the second type.
 *
 * He wants to distribute candies in such a way that no person has candies of both types and each person has at least one candy.
 *
 * Let X denotes the minimum candies among all people after distribution of candies.
 *
 * Find the maximum X.
 *
 * Example:  A=4 B=4 C=5
 *
 * Output = 2
 *
 *
 */
public class CandyDistribution {
    public static void main(String[] args)
    {
        int A = 4, B = 4, C = 5;
        System.out.println(maxCandy(A, B, C));
    }

    private static int maxCandy(int A, int B, int C)
    {
        int low = 1;
        int high = Math.max(B, C);
        int ans = -1;
        while (low <= high)
        {
            int mid = (low + high) >> 1;
            if (isPossible(A, B, C, mid))
            {
                ans = mid;
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return high;
    }

    private static boolean isPossible(int A, int B, int C, int X)
    {
//        for (int i = 1; i <= A; i++)
//        {
//            int group1 = i;
//            int group2 = A - i;
//            if ((long) group1 * X <= B && (long) group2 * X <= C) return true;
//        }
//        return false;
        int people1 = B / X;
        int people2 = C / X;
        return people1 + people2 >= A;
    }
}
