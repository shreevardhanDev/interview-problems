package com.example.interview_questions;

import java.util.Arrays;

/**
 * Interview Question 062: Join Integers Without String Conversion
 *
 * Concatenate integers using mathematical operations instead of string conversion.
 *
 * Problem Statement:
 * Given an array of integers, concatenate them without using string conversion.
 * Result should be the number formed by concatenating all digits.
 *
 * Example:
 * Input: [6, 78, 24, 1, 235]
 * Output: 678241235
 * Explanation: Concatenate 6, 78, 24, 1, 235 to get 678241235
 *
 * Algorithm:
 * - For each number, calculate how many digits it has using log10
 * - Multiply current result by 10^(number of digits)
 * - Add the current number to the result
 * - Time Complexity: O(n*m) where n is array length, m is average number of digits
 * - Space Complexity: O(1)
 */
public class InterviewQuestion062_JoinIntegersWithoutString {
    public static void main(String[] args) {
        System.out.println("=== Join Integers Without String Conversion ===\n");

        // Test Case 1
        int[] arr1 = {6, 78, 24, 1, 235};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + joinIntegers(arr1));
        System.out.println("Expected: 678241235\n");

        // Test Case 2
        int[] arr2 = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + joinIntegers(arr2));
        System.out.println("Expected: 123\n");

        // Test Case 3
        int[] arr3 = {100, 200, 300};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + joinIntegers(arr3));
        System.out.println("Expected: 100200300\n");

        // Test Case 4
        int[] arr4 = {9};
        System.out.println("Input: " + Arrays.toString(arr4));
        System.out.println("Output: " + joinIntegers(arr4));
        System.out.println("Expected: 9\n");

        // Detailed Example
        System.out.println("=== Detailed Breakdown for [6, 78, 24, 1, 235] ===");
        joinIntegersDetailed(new int[]{6, 78, 24, 1, 235});
    }

    static long joinIntegers(int[] arr) {
        long result = 0;

        for (int num : arr) {
            int digits = countDigits(num);
            long multiplier = power10(digits);
            result = result * multiplier + num;
        }

        return result;
    }

    static int countDigits(int num) {
        if (num == 0) return 1;
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    static long power10(int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= 10;
        }
        return result;
    }

    static void joinIntegersDetailed(int[] arr) {
        System.out.println("Processing: " + Arrays.toString(arr));
        long result = 0;

        for (int num : arr) {
            int digits = countDigits(num);
            long multiplier = power10(digits);
            System.out.println("\nNumber: " + num);
            System.out.println("  Digit count: " + digits);
            System.out.println("  Multiplier (10^" + digits + "): " + multiplier);
            System.out.println("  Calculation: " + result + " * " + multiplier + " + " + num + " = " + (result * multiplier + num));
            result = result * multiplier + num;
        }

        System.out.println("\nFinal Result: " + result);
    }
}
