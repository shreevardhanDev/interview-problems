package com.example.interview_questions;

import java.util.*;

/**
 * Interview Question 066: Remove Duplicates Preserving Order
 *
 * Remove duplicate elements from an array while preserving insertion order.
 *
 * Problem Statement:
 * Given an array with potential duplicates, remove all duplicates
 * and return the array with unique elements in their original order.
 *
 * Example:
 * Input: [10, 20, 30, 40, 60, 10]
 * Output: [10, 20, 30, 40, 60]
 * Explanation: Keep the first occurrence of 10, remove the duplicate at the end
 *
 * Algorithm:
 * - Use LinkedHashSet (maintains insertion order) to track seen elements
 * - Or use HashSet with stream filter
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 */
public class InterviewQuestion066_RemoveDuplicatesPreservingOrder {
    public static void main(String[] args) {
        System.out.println("=== Remove Duplicates Preserving Order ===\n");

        // Test Case 1
        int[] arr1 = {10, 20, 30, 40, 60, 10};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(removeDuplicates(arr1)));
        System.out.println("Expected: [10, 20, 30, 40, 60]\n");

        // Test Case 2
        int[] arr2 = {1, 1, 1, 1};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(removeDuplicates(arr2)));
        System.out.println("Expected: [1]\n");

        // Test Case 3
        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + Arrays.toString(removeDuplicates(arr3)));
        System.out.println("Expected: [1, 2, 3, 4, 5]\n");

        // Test Case 4
        int[] arr4 = {5, 3, 3, 1, 3, 5};
        System.out.println("Input: " + Arrays.toString(arr4));
        System.out.println("Output: " + Arrays.toString(removeDuplicates(arr4)));
        System.out.println("Expected: [5, 3, 1]\n");

        // Using Stream API
        System.out.println("=== Using Stream API ===");
        int[] arr5 = {10, 20, 30, 40, 60, 10};
        System.out.println("Input: " + Arrays.toString(arr5));
        System.out.println("Output: " + removeDuplicatesStream(arr5));
        System.out.println("Expected: [10, 20, 30, 40, 60]\n");

        // Detailed Example
        System.out.println("=== Detailed Breakdown ===");
        removeDuplicatesDetailed(new int[]{10, 20, 30, 40, 60, 10});
    }

    static int[] removeDuplicates(int[] arr) {
        Set<Integer> seen = new LinkedHashSet<>();
        for (int num : arr) {
            seen.add(num);
        }

        int[] result = new int[seen.size()];
        int index = 0;
        for (int num : seen) {
            result[index++] = num;
        }
        return result;
    }

    static int[] removeDuplicatesStream(int[] arr) {
        return Arrays.stream(arr)
                     .distinct()
                     .toArray();
    }

    static void removeDuplicatesDetailed(int[] arr) {
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("\nUsing LinkedHashSet (maintains insertion order):");

        Set<Integer> seen = new LinkedHashSet<>();
        System.out.println("Processing elements:");

        for (int num : arr) {
            if (seen.add(num)) {
                System.out.println("  " + num + " - added (first occurrence)");
            } else {
                System.out.println("  " + num + " - skipped (already seen)");
            }
        }

        System.out.println("\nUnique elements in order: " + seen);

        int[] result = new int[seen.size()];
        int index = 0;
        for (int num : seen) {
            result[index++] = num;
        }

        System.out.println("Result array: " + Arrays.toString(result));
    }
}
