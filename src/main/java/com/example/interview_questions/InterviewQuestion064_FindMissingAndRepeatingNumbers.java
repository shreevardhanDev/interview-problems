package com.example.interview_questions;

import java.util.*;

/**
 * Interview Question 064: Find Missing and Repeating Numbers
 *
 * Find both the missing number and repeating number in an array.
 *
 * Problem Statement:
 * Given an array where all numbers should be from 1 to n, find:
 * 1. The number that appears more than once (repeating)
 * 2. The number that is missing from the sequence
 *
 * Example:
 * Input: [3, 1, 1, 4, 4]
 * Expected range: 1 to 5
 * Output: Missing = 2, Repeating = [1, 4]
 * Explanation: 2 is missing, 1 and 4 appear more than once
 *
 * Algorithm:
 * - Use HashMap to track frequency of each number
 * - Create a set of expected numbers 1 to n
 * - Find repeating: numbers with frequency > 1
 * - Find missing: numbers in range not present
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 */
public class InterviewQuestion064_FindMissingAndRepeatingNumbers {
    public static void main(String[] args) {
        System.out.println("=== Find Missing and Repeating Numbers ===\n");

        // Test Case 1
        int[] arr1 = {3, 1, 1, 4, 4};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Array length (n): " + arr1.length);
        findMissingAndRepeating(arr1);
        System.out.println();

        // Test Case 2
        int[] arr2 = {1, 2, 3, 4, 4};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Array length (n): " + arr2.length);
        findMissingAndRepeating(arr2);
        System.out.println();

        // Test Case 3
        int[] arr3 = {2, 2, 3, 4, 5};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Array length (n): " + arr3.length);
        findMissingAndRepeating(arr3);
        System.out.println();

        // Test Case 4
        int[] arr4 = {1, 1};
        System.out.println("Input: " + Arrays.toString(arr4));
        System.out.println("Array length (n): " + arr4.length);
        findMissingAndRepeating(arr4);
        System.out.println();

        // Detailed Example
        System.out.println("=== Detailed Breakdown for [3, 1, 1, 4, 4] ===");
        findMissingAndRepeatingDetailed(new int[]{3, 1, 1, 4, 4});
    }

    static void findMissingAndRepeating(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();
        Set<Integer> expected = new HashSet<>();

        int n = arr.length;
        for (int i = 1; i <= n; i++) {
            expected.add(i);
        }

        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        List<Integer> repeating = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > 1) {
                repeating.add(entry.getKey());
            }
        }

        List<Integer> missing = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!frequency.containsKey(i)) {
                missing.add(i);
            }
        }

        System.out.println("Missing numbers: " + missing);
        System.out.println("Repeating numbers: " + repeating);
    }

    static void findMissingAndRepeatingDetailed(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int n = arr.length;

        System.out.println("Expected range: 1 to " + n);
        System.out.println("\nBuilding frequency map:");

        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        System.out.println("Frequency map: " + frequency);

        System.out.println("\nFinding repeating numbers (frequency > 1):");
        List<Integer> repeating = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("  " + entry.getKey() + " appears " + entry.getValue() + " times");
                repeating.add(entry.getKey());
            }
        }

        System.out.println("\nFinding missing numbers (not in frequency map):");
        List<Integer> missing = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!frequency.containsKey(i)) {
                System.out.println("  " + i + " is missing");
                missing.add(i);
            }
        }

        System.out.println("\nResult:");
        System.out.println("  Missing: " + missing);
        System.out.println("  Repeating: " + repeating);
    }
}
