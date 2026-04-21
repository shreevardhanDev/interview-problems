package com.example.interview_questions;

/**
 * Interview Question 028: Missing Number (LeetCode 268)
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 * Example:
 * Input: nums = [3,0,1]
 * Output: 2
 *
 * Explanation: Use XOR or sum.
 */
public class InterviewQuestion028_MissingNumber {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion028_MissingNumber");
        int[] nums = {3, 0, 1};
        int result = missingNumber(nums);
        System.out.println(result); // Output: 2
    }

    static int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}