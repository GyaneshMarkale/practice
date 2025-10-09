package DSA;

public class SecondLargestAndSmallestSum {
    public static void main(String[] args)
    {
        int [] arr = {3,6,2,8, 8, 1, 2, 1};
        int a[]={1,6,0,7,8,8,9};
        int[] arr1 = {1, 1, 1, 1, 1};
        int[] arr2 = {0, 1};
        int[] arr3 = {0};
        System.out.println(sum(arr));
        System.out.println(sum(a));
        System.out.println(sum(arr1));
        System.out.println(sum(arr2));
        System.out.println(sum(arr3));

    }

    public static int sum(int[] arr)
    {
        int n =  arr.length;
        if (n == 1) return arr[0];
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
        {
            if (arr[i] > largest)
            {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest)
            {
                secondLargest = arr[i];
            }

            if(arr[i] < smallest)
            {
                secondSmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] > smallest && arr[i] < secondSmallest)
            {
                secondSmallest = arr[i];
            }
        }
        if (secondSmallest == Integer.MAX_VALUE || secondLargest == Integer.MIN_VALUE) {
            return -1; // If they don't exist, return -1
        };
        return secondLargest + secondSmallest;
    }
}
