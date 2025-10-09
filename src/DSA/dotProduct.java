package DSA;

public class dotProduct {
    public static void main(String[] args)
    {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        System.out.println("Dot Product: " + dotProduct(arr1, arr2)); // Output: 32

        int[] arr3 = {1, 2};
        int[] arr4 = {3, 4, 5};
        System.out.println("Dot Product: " + dotProduct(arr3, arr4)); // Output: -1

        int[] arr5 = {};
        int[] arr6 = {};
        System.out.println("Dot Product: " + dotProduct(arr5, arr6)); // Output:
    }

    public static int dotProduct(int[] arr1, int[] arr2)
    {
        if (arr1.length != arr2.length) return -1;
        int n = arr1.length;
        int dp = 0;
       for (int i = 0; i < n; i++)
        {
            dp += arr1[i] * arr2[i];
        }
       return dp;
    }
}
