package DSA;

import java.util.*;

/**
 *  {1, 4, 0, 8, 2}
 *  {4, 8, 8, -1, -1}
 *  {
 *     4, 8, 8,-1, 4
 *  }
 */
// 8 4 1
public class NGE {
    public static void main(String [] args)
    {
        int[] arr  = {1, 4, 0, 8, 2};
        int[] res = getNextGreaterElement(arr);
        for (int out: res)
        {
            System.out.print(" "+out);
        }
    }

    private static int[] getNextGreaterElement(int[] arr)
    {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * (n-1); i >= 0; i--)  //-- 2 * arr -- 2n
        {
            while (!stack.isEmpty() && stack.peek() <= arr[i % n])  // n
            {
                stack.pop();
            }
            nge[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i % n]);
        }
        return nge;
    }
}

