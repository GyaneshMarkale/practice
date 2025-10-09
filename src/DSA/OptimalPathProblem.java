package DSA;

public class OptimalPathProblem {
    public static void main(String[] args)
    {
        int[][] input = {{0, 0, 0, 0, 5},
                         {0, 1, 1, 1, 0},
                         {2, 0, 0, 0, 0}};

        System.out.println(optimalPath(input));

    }

    private static int optimalPath(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][0] = grid[n-1][0];
        for (int i = n-2; i >=0; i--)
        {
            dp[i][0] = grid[i][0] + dp[i+1][0];
        }

        for (int j = 1; j < m; j++)
        {
            dp[n-1][j] = grid[n-1][j] + dp[n-1][j-1];
        }

        for (int i = n-2; i >= 0; i--)
        {
            for (int j = 1; j < m; j++)
            {
                int up = dp[i+1][j];
                int right = dp[i][j-1];
                dp[i][j] = grid[i][j] + Math.max(up, right);
            }
        }
        return dp[0][m-1];
    }
}
