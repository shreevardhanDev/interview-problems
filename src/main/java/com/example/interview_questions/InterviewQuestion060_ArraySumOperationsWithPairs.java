package com.example.interview_questions;

import java.util.*;

/**
 * Interview Question 060: Array Sum Operations with Pairs
 *
 * Calculate sum of pair products and other pair operations on an array.
 *
 * Problem Statement:
 * Given an array, calculate various sum operations involving pairs of elements.
 * Common operations:
 * 1. Sum of (i * arr[i]) for all elements
 * 2. Sum of (arr[i] * arr[j]) for all pairs where i < j
 * 3. Sum of absolute differences between all pairs
 *
 * Example:
 * Input: [5, 3, 1, 2]
 * Sum of index * value: 0*5 + 1*3 + 2*1 + 3*2 = 0 + 3 + 2 + 6 = 11
 * Sum of all pair products: 5*3 + 5*1 + 5*2 + 3*1 + 3*2 + 1*2 = 45
 *
 * Algorithm:
 * - Brute force: nested loops for all pairs - O(n^2)
 * - Optimized: use sorting and mathematical properties
 * - Time Complexity: O(n^2) for pair products, O(n) for index*value
 * - Space Complexity: O(1)
 */
public class InterviewQuestion060_ArraySumOperationsWithPairs {
    public static void main(String[] args) {
        System.out.println("=== Array Sum Operations with Pairs ===\n");

        // Test Case 1
        int[] arr1 = {5, 3, 1, 2};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Sum of (index * value): " + sumIndexValue(arr1));
        System.out.println("Sum of all pair products: " + sumPairProducts(arr1));
        System.out.println("Sum of absolute differences: " + sumAbsoluteDifferences(arr1));
        System.out.println();

        // Test Case 2
        int[] arr2 = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Sum of (index * value): " + sumIndexValue(arr2));
        System.out.println("Sum of all pair products: " + sumPairProducts(arr2));
        System.out.println("Sum of absolute differences: " + sumAbsoluteDifferences(arr2));
        System.out.println();

        // Test Case 3
        int[] arr3 = {10};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Sum of (index * value): " + sumIndexValue(arr3));
        System.out.println("Sum of all pair products: " + sumPairProducts(arr3));
        System.out.println("Sum of absolute differences: " + sumAbsoluteDifferences(arr3));
        System.out.println();

        // Detailed Example
        System.out.println("=== Detailed Breakdown for [5, 3, 1, 2] ===");
        detailedBreakdown(new int[]{5, 3, 1, 2});
    }

    static long sumIndexValue(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += i * arr[i];
        }
        return sum;
    }

    static long sumPairProducts(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum += (long) arr[i] * arr[j];
            }
        }
        return sum;
    }

    static long sumAbsoluteDifferences(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum += Math.abs(arr[i] - arr[j]);
            }
        }
        return sum;
    }

    static void detailedBreakdown(int[] arr) {
        System.out.println("\n--- Sum of (index * value) ---");
        System.out.println("Calculation: 0*5 + 1*3 + 2*1 + 3*2");
        long indexSum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("  " + i + " * " + arr[i] + " = " + (i * arr[i]));
            indexSum += i * arr[i];
        }
        System.out.println("Total: " + indexSum);

        System.out.println("\n--- Sum of all pair products ---");
        System.out.println("All pairs (i < j):");
        long pairSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                long product = (long) arr[i] * arr[j];
                System.out.println("  (" + arr[i] + ", " + arr[j] + ") -> " + arr[i] + " * " + arr[j] + " = " + product);
                pairSum += product;
            }
        }
        System.out.println("Total: " + pairSum);

        System.out.println("\n--- Sum of absolute differences ---");
        System.out.println("All pairs (i < j):");
        long diffSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                long diff = Math.abs(arr[i] - arr[j]);
                System.out.println("  (" + arr[i] + ", " + arr[j] + ") -> |" + arr[i] + " - " + arr[j] + "| = " + diff);
                diffSum += diff;
            }
        }
        System.out.println("Total: " + diffSum);
    }
}
