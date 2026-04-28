package com.example.interview_questions;

import java.util.*;

/**
 * Interview Question 053: First Non-Repeating Character (LinkedHashMap Version)
 *
 * Find the first non-repeating character in an array using LinkedHashMap.
 *
 * Problem Statement:
 * Given an array of integers, find the first element that appears only once,
 * using LinkedHashMap to maintain insertion order.
 *
 * Example:
 * Input: [20,1,2,10,20,1,3,2,5]
 * Output: 10
 * Explanation: 10 is the first element that appears only once
 * (20 appears twice, 1 appears twice, 2 appears twice, 10 appears once)
 *
 * Algorithm:
 * - Use LinkedHashMap to track frequency and insertion order
 * - LinkedHashMap maintains insertion order of entries
 * - First iterate to build frequency map
 * - Then iterate to find first with frequency 1
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 */
public class InterviewQuestion053_FirstNonRepeatingCharacterLinkedHashMap {
    public static void main(String[] args) {
        System.out.println("=== First Non-Repeating Character (LinkedHashMap) ===\n");

        // Test Case 1
        int[] arr1 = {20, 1, 2, 10, 20, 1, 3, 2, 5};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + findFirstNonRepeating(arr1));
        System.out.println("Expected: 10\n");

        // Test Case 2
        int[] arr2 = {1, 1, 1, 2, 2, 3};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + findFirstNonRepeating(arr2));
        System.out.println("Expected: 3\n");

        // Test Case 3
        int[] arr3 = {7, 7, 7, 7};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + findFirstNonRepeating(arr3));
        System.out.println("Expected: -1 (no unique element)\n");

        // Test Case 4
        int[] arr4 = {5};
        System.out.println("Input: " + Arrays.toString(arr4));
        System.out.println("Output: " + findFirstNonRepeating(arr4));
        System.out.println("Expected: 5\n");

        // Detailed Example
        int[] test = {20, 1, 2, 10, 20, 1, 3, 2, 5};
        System.out.println("=== Detailed Breakdown ===");
        findFirstNonRepeatingDetailed(test);
    }

    static int findFirstNonRepeating(int[] arr) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    static void findFirstNonRepeatingDetailed(int[] arr) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        System.out.println("Building frequency map with insertion order:");
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println("\nFrequency Map (maintains insertion order):");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nFinding first element with frequency 1:");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("  First non-repeating: " + entry.getKey());
                return;
            }
        }

        System.out.println("  No non-repeating element found");
    }
}
