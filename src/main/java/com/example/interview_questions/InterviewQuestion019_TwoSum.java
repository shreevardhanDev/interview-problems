package com.example.interview_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Interview Question 019: Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 *
 * Explanation: Use hash map for O(n) time.
 */
public class InterviewQuestion019_TwoSum {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion019_TwoSum");
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // Output: [0,1]
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}