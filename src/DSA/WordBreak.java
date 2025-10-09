package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args)
    {
        String s = "leetcode";
        List<String> list = new ArrayList<>(Arrays.asList("leet", "code"));
        boolean possible = wordBreak(s, list);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int len = 1; len <= n; len++)
        {
            for (int i = 0; i < n; i++)
            {
                if (dp[i] && wordDict.contains(s.substring(i, len)))
                {
                    dp[len] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
