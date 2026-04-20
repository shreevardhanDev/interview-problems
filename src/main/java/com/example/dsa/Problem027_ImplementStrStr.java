package com.example.dsa;

/**
 * Problem 027: Implement strStr()
 *
 * Return the index of the first occurrence of needle in haystack, or -1 when not present.
 *
 * Solution explanation in code comments.
 */
public class Problem027_ImplementStrStr {
    public static void main(String[] args) {
        System.out.println("Running Problem027_ImplementStrStr");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
