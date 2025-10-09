/**
 * arr1 = {2,4,5, 0,0,0}
 * arr2 = {1,3,4}
 *
 * arr 1 = {1, 2, ,3, 4, 4, 5}
 *
 * arr1 = {2, 4, 5 , 1,3,4} -- > mergeSort -> {1, 2, ,3, 4, 4, 5}
 *
 * tc - > 0(size arr2) +  O(nlogn)
 */
package JAVA;

public class solution1 {
    public static void main(String[] args)
    {
        int[] arr1 =  {2,2,3, 0, 0};
        int[] arr2 =  {1,5};
        mergeAndSortArrays(arr1, arr2);
        for (int i = 0; i < arr1.length; i++)
        {
            System.out.println(" "+ arr1[i]);
        }
    }

    private static void mergeAndSortArrays(int[] arr1, int[] arr2)
    {
        int arr1L = arr1.length;
        int m = arr2.length;
        int n =  arr1L - m;
        int left =  n - 1;
        int right = m - 1;
        int k = arr1L -1;
        while (right >= 0)
        {
            if (left >= 0 && arr1[left] >= arr2[right])
            {
                arr1[k] = arr1[left];
                left--;
                k--;
            }
            else {
                arr1[k] = arr2[right];
                right--;
                k--;
            }
        }
    }
}
