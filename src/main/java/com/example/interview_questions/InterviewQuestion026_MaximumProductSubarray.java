package com.example.interview_questions;

/**
 * Interview Question 026: Maximum Product Subarray (LC152)
 *
 * Given an integer array nums, find a contiguous non-empty subarray with the largest product.
 *
 * Problem Statement:
 * You need to find the contiguous subarray with the maximum product value.
 * Handle negative numbers and zeros properly using a technique that tracks both
 * maximum and minimum products at each position.
 *
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product = 6.
 *
 * Example 2:
 * Input: nums = [-2]
 * Output: -2
 *
 * Example 3:
 * Input: nums = [0,2]
 * Output: 2
 *
 * Algorithm: Dynamic Programming
 * - Track both max and min products ending at each position
 * - Min is important because a negative number can flip a large negative to large positive
 * - Time Complexity: O(n)
 * - Space Complexity: O(1)
 */
public class InterviewQuestion026_MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println("=== Maximum Product Subarray ===\n");

        // Test Case 1
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Input: " + arrayToString(nums1));
        System.out.println("Output: " + maxProduct(nums1));
        System.out.println("Expected: 6\n");

        // Test Case 2
        int[] nums2 = {-2};
        System.out.println("Input: " + arrayToString(nums2));
        System.out.println("Output: " + maxProduct(nums2));
        System.out.println("Expected: -2\n");

        // Test Case 3
        int[] nums3 = {0, 2};
        System.out.println("Input: " + arrayToString(nums3));
        System.out.println("Output: " + maxProduct(nums3));
        System.out.println("Expected: 2\n");

        // Test Case 4
        int[] nums4 = {-2, 3, -4};
        System.out.println("Input: " + arrayToString(nums4));
        System.out.println("Output: " + maxProduct(nums4));
        System.out.println("Expected: 24\n");

        // Test Case 5
        int[] nums5 = {2, -5, -2, -4, 3};
        System.out.println("Input: " + arrayToString(nums5));
        System.out.println("Output: " + maxProduct(nums5));
        System.out.println("Expected: 24\n");
    }

    static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            int tempMax = maxProd;

            maxProd = Math.max(num, Math.max(maxProd * num, minProd * num));
            minProd = Math.min(num, Math.min(tempMax * num, minProd * num));

            result = Math.max(result, maxProd);
        }

        return result;
    }

    static String arrayToString(int[] nums) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i < nums.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
