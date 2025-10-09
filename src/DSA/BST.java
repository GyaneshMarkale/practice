package DSA;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class BST {
    public static void main(String[] args)
    {
        TreeNode root = null;
        root = insertNode(root, 50);
        root = insertNode(root, 30);
        root = insertNode(root, 20);
        root = insertNode(root, 40);
        root = insertNode(root, 70);
        root = insertNode(root, 60);
        root = insertNode(root, 80);
        List<Integer> inorderList = inorder(root, new ArrayList<>());
        System.out.println(inorderList);

        System.out.println(valContains(root, 80));
    }

    public static boolean valContains(TreeNode root, int data)
    {
        if (root == null) return false;
        if (data == root.val) return true;
        else if (data < root.val)
        {
            if (root.left != null) return valContains(root.left, data);
        }
        else
        {
            if (root.right != null) return valContains(root.right, data);
        }
        return false;
    }

    public static TreeNode insertNode (TreeNode root, int data)
    {
        if (root == null) return new TreeNode(data);
        if (data == root.val) return root;
        if (data < root.val)
        {
            root.left = insertNode(root.left, data);
        }
        else  root.right = insertNode(root.right, data);
        return root;
    }

    public static List<Integer> inorder (TreeNode root, List<Integer> inorderList)
    {
        if (root == null) return inorderList;
        inorder(root.left, inorderList);
        inorderList.add(root.val);
        inorder(root.right, inorderList);
        return inorderList;
    }
}
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val)
    {
        this.val = val;
    }
}
