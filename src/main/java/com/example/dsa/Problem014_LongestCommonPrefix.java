package com.example.dsa;

/**
 * Problem 014: Longest Common Prefix
 *
 * Find the longest common prefix string amongst an array of strings.
 *
 * Solution explanation in code comments.
 */
public class Problem014_LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println("Running Problem014_LongestCommonPrefix");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
