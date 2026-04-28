package com.example.interview_questions;

import java.util.Arrays;

/**
 * Interview Question 065: Maximum Element in Array
 *
 * Find the maximum element in an array.
 *
 * Problem Statement:
 * Given an array of integers, find and return the maximum element.
 *
 * Example:
 * Input: [10, 20, 30, 40, 60, 10]
 * Output: 60
 * Explanation: 60 is the largest element in the array
 *
 * Algorithm:
 * - Single pass through array tracking maximum value
 * - Time Complexity: O(n)
 * - Space Complexity: O(1)
 *
 * Alternative:
 * - Use Comparator.maxBy() with Stream API
 * - Time Complexity: O(n)
 * - Space Complexity: O(1)
 */
public class InterviewQuestion065_MaximumElement {
    public static void main(String[] args) {
        System.out.println("=== Maximum Element in Array ===\n");

        // Test Case 1
        int[] arr1 = {10, 20, 30, 40, 60, 10};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + findMax(arr1));
        System.out.println("Expected: 60\n");

        // Test Case 2
        int[] arr2 = {-10, -5, -20, -1};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + findMax(arr2));
        System.out.println("Expected: -1\n");

        // Test Case 3
        int[] arr3 = {0};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + findMax(arr3));
        System.out.println("Expected: 0\n");

        // Test Case 4
        int[] arr4 = {100};
        System.out.println("Input: " + Arrays.toString(arr4));
        System.out.println("Output: " + findMax(arr4));
        System.out.println("Expected: 100\n");

        // Using Stream API
        System.out.println("=== Using Stream API ===");
        int[] arr5 = {10, 20, 30, 40, 60, 10};
        System.out.println("Input: " + Arrays.toString(arr5));
        System.out.println("Output: " + findMaxStream(arr5));
        System.out.println("Expected: 60\n");

        // Detailed Example
        System.out.println("=== Detailed Breakdown ===");
        findMaxDetailed(new int[]{10, 20, 30, 40, 60, 10});
    }

    static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static int findMaxStream(int[] arr) {
        return Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
    }

    static void findMaxDetailed(int[] arr) {
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("\nTraversing array:");

        int max = arr[0];
        System.out.println("Initial max: " + max);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                System.out.println("  arr[" + i + "] = " + arr[i] + " > " + max + ", update max to " + arr[i]);
                max = arr[i];
            } else {
                System.out.println("  arr[" + i + "] = " + arr[i] + " <= " + max + ", no change");
            }
        }

        System.out.println("\nFinal Maximum: " + max);
    }
}
