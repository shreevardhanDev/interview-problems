package com.example.interview_questions;

import java.util.Arrays;

/**
 * Interview Question 005: First Missing Positive
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 *
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 *
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 *
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -2^31 <= nums[i] <= 2^31 - 1
 *
 * Explanation: Use the array itself as a hash set. Place numbers in their correct positions.
 * Time: O(n), Space: O(1)
 */
public class InterviewQuestion005_FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion005_FirstMissingPositive");
        int[] nums = {3, 4, -1, 1, 0};
        int result = firstMissingPositive(nums);
        System.out.println(result); // Output: 2
    }

    /**
     * Find the first missing positive integer.
     *
     * @param nums the array
     * @return the smallest missing positive
     */
    static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        IO.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}