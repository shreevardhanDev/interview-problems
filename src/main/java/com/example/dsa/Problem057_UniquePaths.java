package com.example.dsa;

/**
 * Problem 057: Unique Paths
 *
 * Count unique paths in an m x n grid from top-left to bottom-right only moving right or down.
 *
 * Solution explanation in code comments.
 */
public class Problem057_UniquePaths {
    public static void main(String[] args) {
        System.out.println("Running Problem057_UniquePaths");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
