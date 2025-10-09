import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *Given an array arr[] of n integers where arr[i] represents the
 *  number of chocolates in ith packet. Each packet can have a variable number of chocolates.
 *  There are m students, the task is to distribute chocolate packets such that:
 * Each student gets exactly one packet.
 * The difference between the maximum and minimum number of chocolates in the packets given to the
 * students is minimized.
 *
 * Input: arr[] = {7, 3, 2, 4, 9, 12, 56}, m = 3
 *
 * {2,3,4,7, 9, 12, 56}  -- curr
 */
public class Test22 {
    public static void main(String[] args)
    {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        System.out.println(minChoclates(arr, 3));
        System.out.println(maxSum(new int[] {5,-1,-8,6,8,1}));

    }

    private static int minChoclates(int[] arr, int m)
    {
        Arrays.sort(arr); // nlogn
        int left = 0;
        int right = m-1;
        int mini = Integer.MAX_VALUE;
        while (right < arr.length) // n
        {
            int diff = arr[right] - arr[left];
            mini = Math.min(mini, diff);
            left++;
            right++;
        }
        return mini;
    }

    private static int maxSum(int[] arr)
    {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }

//    public static ArrayList<Integer> boundaryTraversal(Node node) {
//        ArrayList<Integer> res = new ArrayList<>();
//        if (node == null ) return res;
//        res.add(node.data);
//        if (isLeafNode(node))
//        {
//            return res;
//        }
//        leftTraversal(node, res);
//        leafTraversal(node, res);
//        rightTreversal(node, res);
//        return res;
//    }
//
//    private static void leftTraversal(Node node, ArrayList<Integer> res)
//    {
//        Node curr = node;
//        while (curr != null)
//        {
//            if (!isLeafNode(node)) res.add(curr.data);
//            if (curr.left != null) curr = curr.left;
//            if (curr.right != null) curr = curr.right;
//        }
//    }
//
//    private static void leafTraversal(Node node, ArrayList<Integer> res)
//    {
//        if (isLeafNode(node)) res.add(node.data);
//        if (node.left != null) leftTraversal(node.left, res);
//        if (node.right != null) leftTraversal(node.right, res);
//    }
//
//    private static void rightTreversal(Node node, ArrayList<Integer> res)
//    {
//        Node curr = node;
//        Stack<Integer> stack = new Stack<>();
//        while (curr != null)
//        {
//            if (!isLeafNode(curr)) stack.push(curr.data);
//            if (curr.left != null) curr = curr.left;
//            if (curr.right != null) curr = curr.right;
//        }
//
//        while (!stack.isEmpty())
//        {
//            res.add(stack.pop());
//        }
//    }
//
//    public static boolean isLeafNode(Node node)
//    {
//        return node.left == null && node.right == null;
//    }
}

//class Node
//{
//    int data;
//    Node left, right;
//
//    public Node(int d)
//    {
//        data = d;
//        left = right = null;
//    }
//}
