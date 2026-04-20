package com.example.dsa;

/**
 * Problem 042: Wildcard Matching
 *
 * Implement wildcard pattern matching with ? and *.
 *
 * Solution explanation in code comments.
 */
public class Problem042_WildcardMatching {
    public static void main(String[] args) {
        System.out.println("Running Problem042_WildcardMatching");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static boolean isMatchWildcard(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (pc == '?' || pc == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
