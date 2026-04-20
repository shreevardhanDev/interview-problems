package com.example.dsa;

/**
 * Problem 058: Unique Paths II
 *
 * Count unique paths in a grid with obstacles.
 *
 * Solution explanation in code comments.
 */
public class Problem058_UniquePathsII {
    public static void main(String[] args) {
        System.out.println("Running Problem058_UniquePathsII");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int j = 1; j < n; j++) {
            dp[j] = obstacleGrid[0][j] == 0 ? dp[j - 1] : 0;
        }
        for (int i = 1; i < m; i++) {
            dp[0] = obstacleGrid[i][0] == 0 ? dp[0] : 0;
            for (int j = 1; j < n; j++) {
                dp[j] = obstacleGrid[i][j] == 0 ? dp[j] + dp[j - 1] : 0;
            }
        }
        return dp[n - 1];
    }
}
