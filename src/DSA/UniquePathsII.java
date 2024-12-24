package DSA;

import java.util.*;

public class UniquePathsII {
    public static int memorization(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[n - 1][m - 1] = 1;
        int result = solver(obstacleGrid, dp, 0, 0);
        return result;
    }

    public static int solver(int[][] obstacleGrid, int[][] dp, int row, int col) {
        if (dp[row][col] != -1)
            return dp[row][col];

        if (obstacleGrid[row][col] == 1) {
            dp[row][col] = 0;
            return 0;
        }
        int count = 0;
        if (row + 1 < dp.length) {
            if (dp[row + 1][col] == -1)
                solver(obstacleGrid, dp, row + 1, col);
            count += dp[row + 1][col];
        }
        if (col + 1 < dp[0].length) {
            if (dp[row][col + 1] == -1)
                solver(obstacleGrid, dp, row, col + 1);
            count += dp[row][col + 1];
        }

        dp[row][col] = count;
        return dp[row][col];
    }

    

    public static void main(String[] args) {

    }
}
