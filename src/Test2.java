public class Test2 {
    public static void main (String[] args)
    {
        int [] arr = {10, 15, 5, 13, 5, 17, 20};
        int [] res = sortedArray(arr);
        for (int i =0 ; i < res.length; i++)
        {
            System.out.println(res[i]);
        }
    }
    public static int[] sortedArray (int[] arr)
    {
        int[] res = new int[arr.length];
        int max = maxValue(arr);
        int[] temp = new int[max+1];
        System.out.println(temp.length);
        for (int i =0 ; i < arr.length; i++)
        {
            temp[arr[i]] = arr[i];  /// temp[10] = 1
        }
        System.out.println(temp[20]);
        int j = 0;
        for (int i =0 ; i < temp.length; i++)
        {
            if (temp[i] != 0)
            {
                res[j] = temp[i];
                j++;
            }
        }
        return res;
    }
    public static int maxValue(int[] arr)
    {
        int maxValue = Integer.MIN_VALUE;
        for (int i =0 ; i < arr.length; i++)
        {
            if (arr[i] > maxValue)
            {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

}


