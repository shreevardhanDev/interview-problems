package com.example.interview_questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Interview Question 031: Subarray Sum Equals K (LeetCode 560)
 *
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 * Example:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 * Explanation: Use prefix sum and map.
 */
public class InterviewQuestion031_SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion031_SubarraySumEqualsK");
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = subarraySum(nums, k);
        System.out.println(result); // Output: 2
    }

    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}