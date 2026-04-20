package com.example.dsa;

/**
 * Problem 094: Palindrome Partitioning
 *
 * Return all palindrome partitioning combinations of a string.
 *
 * Solution explanation in code comments.
 */
public class Problem094_PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println("Running Problem094_PalindromePartitioning");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static java.util.List<java.util.List<String>> partition(String s) {
        java.util.List<java.util.List<String>> result = new java.util.ArrayList<>();
        backtrackPartition(result, new java.util.ArrayList<>(), s, 0);
        return result;
    }
    private static void backtrackPartition(java.util.List<java.util.List<String>> result, java.util.List<String> current, String s, int index) {
        if (index == s.length()) {
            result.add(new java.util.ArrayList<>(current));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String prefix = s.substring(index, i);
            if (isPalindromeString(prefix)) {
                current.add(prefix);
                backtrackPartition(result, current, s, i);
                current.remove(current.size() - 1);
            }
        }
    }
    private static boolean isPalindromeString(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
