package com.example.interview_questions;

/**
 * Interview Question 024: Find the Duplicate Number (LeetCode 287)
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 * Example:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Explanation: Use Floyd's cycle detection.
 */
public class InterviewQuestion024_FindTheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion024_FindTheDuplicateNumber");
        int[] nums = {1, 3, 4, 2, 2};
        int result = findDuplicate(nums);
        System.out.println(result); // Output: 2
    }

    static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}