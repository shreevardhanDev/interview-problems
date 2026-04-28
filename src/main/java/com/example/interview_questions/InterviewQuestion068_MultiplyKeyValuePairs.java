package com.example.interview_questions;

import java.util.*;

/**
 * Interview Question 068: Multiply Key-Value Pairs
 *
 * Multiply each index by its corresponding array value.
 *
 * Problem Statement:
 * Given an array and a size n, for each element at index i,
 * multiply the index with the value at that index.
 * Create a new array with these products.
 *
 * Example:
 * Input: arr = [1, 2, 4, 5, 3], n = 5
 * Output: [0, 2, 8, 15, 12]
 * Explanation:
 * - Index 0: 0 * 1 = 0
 * - Index 1: 1 * 2 = 2
 * - Index 2: 2 * 4 = 8
 * - Index 3: 3 * 5 = 15
 * - Index 4: 4 * 3 = 12
 *
 * Algorithm:
 * - Simple iteration through array
 * - For each index i, multiply i * arr[i]
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 */
public class InterviewQuestion068_MultiplyKeyValuePairs {
    public static void main(String[] args) {
        System.out.println("=== Multiply Key-Value Pairs (Index * Value) ===\n");

        // Test Case 1
        int[] arr1 = {1, 2, 4, 5, 3};
        System.out.println("Input: arr = " + Arrays.toString(arr1) + ", n = " + arr1.length);
        System.out.println("Output: " + Arrays.toString(multiplyKeyValues(arr1)));
        System.out.println("Expected: [0, 2, 8, 15, 12]\n");

        // Test Case 2
        int[] arr2 = {5, 3, 1, 2};
        System.out.println("Input: arr = " + Arrays.toString(arr2) + ", n = " + arr2.length);
        System.out.println("Output: " + Arrays.toString(multiplyKeyValues(arr2)));
        System.out.println("Expected: [0, 3, 2, 6]\n");

        // Test Case 3
        int[] arr3 = {1};
        System.out.println("Input: arr = " + Arrays.toString(arr3) + ", n = " + arr3.length);
        System.out.println("Output: " + Arrays.toString(multiplyKeyValues(arr3)));
        System.out.println("Expected: [0]\n");

        // Test Case 4
        int[] arr4 = {10, 20, 30, 40};
        System.out.println("Input: arr = " + Arrays.toString(arr4) + ", n = " + arr4.length);
        System.out.println("Output: " + Arrays.toString(multiplyKeyValues(arr4)));
        System.out.println("Expected: [0, 20, 60, 120]\n");

        // Detailed Example
        System.out.println("=== Detailed Breakdown ===");
        multiplyKeyValuesDetailed(new int[]{1, 2, 4, 5, 3});
    }

    static int[] multiplyKeyValues(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = i * arr[i];
        }

        return result;
    }

    static void multiplyKeyValuesDetailed(int[] arr) {
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Array length (n): " + arr.length);

        System.out.println("\nCalculating index * value for each element:");
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = i * arr[i];
            System.out.println("  Index " + i + ": " + i + " * " + arr[i] + " = " + result[i]);
        }

        System.out.println("\nResult: " + Arrays.toString(result));
    }
}
