package com.example.dsa;

/**
 * Problem 092: Valid Palindrome
 *
 * Check if a string is a palindrome ignoring non-alphanumeric characters and case.
 *
 * Solution explanation in code comments.
 */
public class Problem092_ValidPalindrome {
    public static void main(String[] args) {
        System.out.println("Running Problem092_ValidPalindrome");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++; right--;
        }
        return true;
    }
}
