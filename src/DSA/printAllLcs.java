package DSA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class printAllLcs {
    public static void main(String [] args)
    {
        System.out.println(all_longest_common_subsequences("abaaa", "baabaca"));
    }
    public static List<String> all_longest_common_subsequences(String s, String t) {
        List<String> res= new ArrayList<>();
        Set<String> set = getAllLcs(s, t);
        for (String se : set)
        {
            res.add(se);
        }
        return res;
    }

    public static Set<String> getAllLcs(String s, String t)
    {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (s.charAt(i-1) == t.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int lcs = dp[n][m];
        Set<String> set = new HashSet<>();
        for (int k = m; k >= 0; k--)
        {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            int i = n;
            int j = m;
            if (dp[i][k] > lcs) break;
            while (i > 0 && j > 0)
            {
                if (s.charAt(i-1) == t.charAt(j-1))
                {
                    sb.append(s.charAt(i-1));
                    i--;
                    j--;
                }
                else if (dp[i-1][j] > dp[i][j-1]) i--;
                else j--;
            }
            sb.reverse();
            System.out.println(sb.toString());
            set.add(sb.toString());
        }
        return set;
    }
}

