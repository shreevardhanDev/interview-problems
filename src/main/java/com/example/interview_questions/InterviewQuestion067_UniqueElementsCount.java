package com.example.interview_questions;

import java.util.*;

/**
 * Interview Question 067: Count of Unique Elements (Appearing Exactly Once)
 *
 * Count elements that appear exactly one time in an array.
 *
 * Problem Statement:
 * Given an array of integers, count how many elements appear exactly once
 * (appear only one time in the entire array).
 *
 * Example:
 * Input: [10, 20, 30, 40, 10]
 * Output: 3
 * Explanation: 20, 30, 40 appear exactly once. 10 appears twice.
 *
 * Algorithm:
 * - Use HashMap to track frequency of each element
 * - Count how many have frequency equal to 1
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 */
public class InterviewQuestion067_UniqueElementsCount {
    public static void main(String[] args) {
        System.out.println("=== Count of Unique Elements ===\n");

        // Test Case 1
        int[] arr1 = {10, 20, 30, 40, 10};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + countUniqueElements(arr1));
        System.out.println("Expected: 3\n");

        // Test Case 2
        int[] arr2 = {1, 1, 1, 1};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + countUniqueElements(arr2));
        System.out.println("Expected: 0\n");

        // Test Case 3
        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + countUniqueElements(arr3));
        System.out.println("Expected: 5\n");

        // Test Case 4
        int[] arr4 = {5, 5, 5, 1, 1, 2};
        System.out.println("Input: " + Arrays.toString(arr4));
        System.out.println("Output: " + countUniqueElements(arr4));
        System.out.println("Expected: 1\n");

        // Detailed Example
        System.out.println("=== Detailed Breakdown ===");
        countUniqueElementsDetailed(new int[]{10, 20, 30, 40, 10});
    }

    static int countUniqueElements(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int freq : frequency.values()) {
            if (freq == 1) {
                count++;
            }
        }

        return count;
    }

    static void countUniqueElementsDetailed(int[] arr) {
        System.out.println("Input: " + Arrays.toString(arr));

        Map<Integer, Integer> frequency = new HashMap<>();
        System.out.println("\nBuilding frequency map:");

        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nCounting elements with frequency = 1:");
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("  " + entry.getKey() + " appears exactly once");
                count++;
            }
        }

        System.out.println("\nTotal unique elements: " + count);
    }
}
