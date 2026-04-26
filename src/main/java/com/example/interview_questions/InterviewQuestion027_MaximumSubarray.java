package com.example.interview_questions;

/**
 * Interview Question 027: Maximum Subarray (LeetCode 53)
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 *
 * Explanation: Kadane's algorithm.
 */
public class InterviewQuestion027_MaximumSubarray {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion027_MaximumSubarray");
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println(result); // Output: 6
    }

    static int maxSubArray(int[] nums) {
        int max = nums[0], current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}