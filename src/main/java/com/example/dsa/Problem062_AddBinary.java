package com.example.dsa;

/**
 * Problem 062: Add Binary
 *
 * Add two binary strings and return their sum as a binary string.
 *
 * Solution explanation in code comments.
 */
public class Problem062_AddBinary {
    public static void main(String[] args) {
        System.out.println("Running Problem062_AddBinary");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum % 2);
            carry = sum / 2;
        }
        return result.reverse().toString();
    }
}
