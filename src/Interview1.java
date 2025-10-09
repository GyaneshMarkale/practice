import java.util.Arrays;
import java.util.List;

public class Interview1 {

    /**
     * Input: arr[] = [1, 2, 0, 3]
     * Output: 2
     *
     * Input: arr[] = [-7, 1, 5, 2, -4, 3, 0]
     * Output: 3
     * -7 + 1 + 5 = -1 and sum on
     * right of index 3 is -4 + 3 + 0 = -1
     *
     * [1,2,3,1,1,1,0,9]
     * 6
     */


    public static void main(String[] args)
    {
        int[] arr = {1,2,3,1,1,2,0,9};
        //System.out.println(findEquilibriumPoint(arr));
        List<String> s = Arrays.asList("and", "gy", "ma");
        //s.remove("gy");
        //System.out.println(s.size());

        String s1 = "abc";
        String s2 = "a" + "b" + "c";
        System.out.println(s1 == s2);


    }

    public static int findEquilibriumPoint(int[] arr)
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int mid = (low + high) / 2;
        while (mid > low && mid < high) {
            int leftSide = calLeftSide(arr, mid);
            int rightSide = calRightSide(arr, mid);
            if (leftSide == rightSide) return mid;

            else if (leftSide > rightSide) {
                mid = mid - 1;
            } else {
                mid = mid + 1;
            }
        }
        return -1;
    }

    public static int calLeftSide(int[] arr, int lastIndex)
    {
        int sum = 0;
        for (int i =0 ; i < lastIndex; i++)
        {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static int calRightSide(int[] arr, int firstIndex)
    {
        int sum = 0;
        for (int i =firstIndex+1 ; i < arr.length; i++)
        {
            sum = sum + arr[i];
        }
        return sum;
    }



}
