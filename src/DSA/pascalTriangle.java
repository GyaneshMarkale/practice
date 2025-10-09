package DSA;

import java.util.ArrayList;
import java.util.List;

public class pascalTriangle {
    public static void main(String[] args)
    {
        System.out.println(generateRow(3));
        System.out.println(generatePascalsTriangle(5));
        System.out.println(getNum(5, 3));

    }

    public static List<List<Integer>> generatePascalsTriangle(int n)
    {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            res.add(generateRow(i));
        }
        return res;
    }

    public static List<Integer> generateRow(int r)
    {
        List<Integer> temp = new ArrayList<>();
        int ans = 1;
        temp.add(ans);
        for (int c = 1; c < r; c++)
        {
            ans = ans * (r - c);
            ans = ans / c;
            temp.add(ans);
        }
        return temp;
    }

    public static int getNum(int r, int c)  // r-1, c-1
    {
        r = r-1;
        c = c-1;
        int ans = 1;
        for (int i = 0; i < c; i++)
        {
            ans = ans * (r - i);
            ans = ans/(i+1);
        }
        return ans;
    }

}
