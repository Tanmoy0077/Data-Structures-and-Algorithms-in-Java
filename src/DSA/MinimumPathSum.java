package DSA;

import java.util.*;

public class MinimumPathSum {
    public static int memorization(int[][] grid){
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        dp[n-1][m-1] = grid[n-1][m-1];
        int result = solver(grid, dp, 0, 0);
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return result;
    }
    public static int solver(int[][] grid, int[][] dp, int row, int col){
        if(dp[row][col] != -1)
            return dp[row][col];
        
        int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(row+1<dp.length){
            if(dp[row+1][col] == -1)
                solver(grid, dp, row+1, col);
            down = dp[row+1][col];
        }
        if(col+1<dp[0].length){
            if(dp[row][col+1] == -1)
                solver(grid, dp, row, col+1);
            right = dp[row][col+1];
        }
        dp[row][col] = Math.min(down, right)+grid[row][col];
        return dp[row][col];
    }
    public static void main(String[] args) {
        int[][] grid = {{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100},{100,100,100}};
        System.out.println(memorization(grid));
    }
}
