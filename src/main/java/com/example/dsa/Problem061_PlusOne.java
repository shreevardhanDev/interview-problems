package com.example.dsa;

/**
 * Problem 061: Plus One
 *
 * Add one to a number represented as an array of digits.
 *
 * Solution explanation in code comments.
 */
public class Problem061_PlusOne {
    public static void main(String[] args) {
        System.out.println("Running Problem061_PlusOne");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
