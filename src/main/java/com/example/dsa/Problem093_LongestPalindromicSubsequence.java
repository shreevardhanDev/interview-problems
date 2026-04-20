package com.example.dsa;

/**
 * Problem 093: Longest Palindromic Subsequence
 *
 * Find the length of the longest palindromic subsequence in a string.
 *
 * Solution explanation in code comments.
 */
public class Problem093_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println("Running Problem093_LongestPalindromicSubsequence");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
