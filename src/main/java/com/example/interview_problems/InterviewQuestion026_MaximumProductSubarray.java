package com.example.interview_questions;

/**
 * Interview Question 026: Maximum Product Subarray (LeetCode 152)
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * Example:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 *
 * Explanation: Keep track of max and min products.
 */
public class InterviewQuestion026_MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion026_MaximumProductSubarray");
        int[] nums = {2, 3, -2, 4};
        int result = maxProduct(nums);
        System.out.println(result); // Output: 6
    }

    static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
            result = Math.max(result, max);
        }
        return result;
    }
}