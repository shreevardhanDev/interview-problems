package com.example.interview_questions;

import java.util.Arrays;

/**
 * Interview Question 063: Square Elements and Sort
 *
 * Square all elements in an array and sort them.
 *
 * Problem Statement:
 * Given an array of integers (possibly negative), square each element
 * and return the array sorted in ascending order.
 *
 * Example:
 * Input: [-3, 1, -2, 2]
 * Output: [1, 4, 4, 9]
 * Explanation: Square each element: [9, 1, 4, 4], then sort: [1, 4, 4, 9]
 *
 * Algorithm:
 * - Square each element using map
 * - Sort the resulting array
 * - Time Complexity: O(n log n)
 * - Space Complexity: O(n) for new array
 *
 * Optimized (for sorted input):
 * - If input is already sorted, use two pointers
 * - Place squares from largest to smallest at the end
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 */
public class InterviewQuestion063_SquareElementsAndSort {
    public static void main(String[] args) {
        System.out.println("=== Square Elements and Sort ===\n");

        // Test Case 1
        int[] arr1 = {-3, 1, -2, 2};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(squareAndSort(arr1)));
        System.out.println("Expected: [1, 4, 4, 9]\n");

        // Test Case 2
        int[] arr2 = {-4, -1, 0, 3, 10};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(squareAndSort(arr2)));
        System.out.println("Expected: [0, 1, 9, 16, 100]\n");

        // Test Case 3
        int[] arr3 = {-7, -3, 2, 3, 11};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + Arrays.toString(squareAndSort(arr3)));
        System.out.println("Expected: [4, 9, 9, 49, 121]\n");

        // Test Case 4
        int[] arr4 = {0};
        System.out.println("Input: " + Arrays.toString(arr4));
        System.out.println("Output: " + Arrays.toString(squareAndSort(arr4)));
        System.out.println("Expected: [0]\n");

        // Optimized approach for sorted input
        System.out.println("=== Optimized Approach (for sorted input) ===");
        int[] arr5 = {-4, -1, 0, 3, 10};
        System.out.println("Input (sorted): " + Arrays.toString(arr5));
        System.out.println("Output: " + Arrays.toString(squareAndSortOptimized(arr5)));
        System.out.println("Expected: [0, 1, 9, 16, 100]\n");

        // Detailed Example
        System.out.println("=== Detailed Breakdown ===");
        squareAndSortDetailed(new int[]{-3, 1, -2, 2});
    }

    static int[] squareAndSort(int[] arr) {
        int[] squared = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            squared[i] = arr[i] * arr[i];
        }
        Arrays.sort(squared);
        return squared;
    }

    static int[] squareAndSortOptimized(int[] arr) {
        int[] result = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                result[i] = arr[left] * arr[left];
                left++;
            } else {
                result[i] = arr[right] * arr[right];
                right--;
            }
        }

        return result;
    }

    static void squareAndSortDetailed(int[] arr) {
        System.out.println("Input: " + Arrays.toString(arr));

        System.out.println("\nStep 1: Square each element");
        int[] squared = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            squared[i] = arr[i] * arr[i];
            System.out.println("  " + arr[i] + "^2 = " + squared[i]);
        }
        System.out.println("After squaring: " + Arrays.toString(squared));

        System.out.println("\nStep 2: Sort the squared array");
        Arrays.sort(squared);
        System.out.println("Final Result: " + Arrays.toString(squared));
    }
}
