package com.example.dsa;

/**
 * Problem 009: Palindrome Number
 *
 * Determine whether an integer reads the same backward as forward without converting to string.
 *
 * Solution explanation in code comments.
 */
public class Problem009_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println("Running Problem009_PalindromeNumber");
        System.out.println(isPalindrome(121));
    }

    // Core solution method
static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int original = x;
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            reversed = reversed * 10 + digit;
        }
        return original == reversed;
    }
}
