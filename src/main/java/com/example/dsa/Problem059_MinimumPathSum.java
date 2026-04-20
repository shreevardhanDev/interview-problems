package com.example.dsa;

/**
 * Problem 059: Minimum Path Sum
 *
 * Find a path from top-left to bottom-right with minimum sum of values.
 *
 * Solution explanation in code comments.
 */
public class Problem059_MinimumPathSum {
    public static void main(String[] args) {
        System.out.println("Running Problem059_MinimumPathSum");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) dp[j] = dp[j - 1] + grid[0][j];
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
