package com.example.dsa;

/**
 * Problem 052: Length of Last Word
 *
 * Return the length of the last word in a string.
 *
 * Solution explanation in code comments.
 */
public class Problem052_LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println("Running Problem052_LengthOfLastWord");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && length > 0) break;
            if (s.charAt(i) != ' ') length++;
        }
        return length;
    }
}
