package com.example.interview_questions;

import java.util.Arrays;

/**
 * Interview Question 061: Top 2 Largest Elements
 *
 * Find the 2 largest elements in an array.
 *
 * Problem Statement:
 * Given an array of integers, find and return the 2 largest elements in descending order.
 *
 * Example:
 * Input: [1, 2, 3, 5, 6]
 * Output: [6, 5]
 * Explanation: 6 is the largest, 5 is the second largest
 *
 * Algorithm:
 * - Sort the array in descending order
 * - Return first 2 elements
 * - Time Complexity: O(n log n)
 * - Space Complexity: O(1)
 *
 * Alternative Optimized:
 * - Single pass through array tracking max1 and max2
 * - Time Complexity: O(n)
 * - Space Complexity: O(1)
 */
public class InterviewQuestion061_Top2LargestElements {
    public static void main(String[] args) {
        System.out.println("=== Top 2 Largest Elements ===\n");

        // Test Case 1
        int[] arr1 = {1, 2, 3, 5, 6};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(top2Largest(arr1)));
        System.out.println("Expected: [6, 5]\n");

        // Test Case 2
        int[] arr2 = {10, 5, 8, 20, 15};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(top2Largest(arr2)));
        System.out.println("Expected: [20, 15]\n");

        // Test Case 3
        int[] arr3 = {-1, -5, -3, -2};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + Arrays.toString(top2Largest(arr3)));
        System.out.println("Expected: [-1, -2]\n");

        // Test Case 4
        int[] arr4 = {100, 100, 50, 50};
        System.out.println("Input: " + Arrays.toString(arr4));
        System.out.println("Output: " + Arrays.toString(top2Largest(arr4)));
        System.out.println("Expected: [100, 100]\n");

        // Comparison of approaches
        System.out.println("=== Approach Comparison ===");
        int[] testArr = {10, 5, 8, 20, 15};
        System.out.println("Input: " + Arrays.toString(testArr));
        System.out.println("Sorting approach: " + Arrays.toString(top2Largest(testArr)));
        System.out.println("Optimized approach: " + Arrays.toString(top2LargestOptimized(testArr)));
    }

    static int[] top2Largest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return new int[]{};
        }

        Integer[] copy = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }

        Arrays.sort(copy, (a, b) -> b - a);

        return new int[]{copy[0], copy[1]};
    }

    static int[] top2LargestOptimized(int[] arr) {
        if (arr == null || arr.length < 2) {
            return new int[]{};
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return new int[]{max1, max2};
    }
}
