package DSA;

public class shortestCommonSupersequence {
    public static void main(String[] args)
    {
        System.out.println(shortestCommonSupersequence("brute", "groot"));
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        // length of supersubsequence = n + m - lenr(lcs)

        int[][] dp = lcsTable(str1, str2, n, m);
        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;
        while (i > 0 && j > 0)
        {
            if (str1.charAt(i-1) == str2.charAt(j-1))
            {
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else
            {
                sb.append(str1.charAt(i-1));
                i--;
            }
        }
        while (i > 0)
        {
            sb.append(str1.charAt(i-1));
        }
        while (j > 0)
        {
            sb.append(str2.charAt(j-1));
        }
        sb.reverse();
        return sb.toString();
    }

    private static int[][] lcsTable (String s1, String s2, int n, int m)
    {
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp;
    }
}
