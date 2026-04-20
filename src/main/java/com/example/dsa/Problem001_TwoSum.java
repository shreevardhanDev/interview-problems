package com.example.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 001: Two Sum
 *
 * Given an array nums and a target, return indices of the two numbers that add up to target.
 *
 * Approach: Hash Map (One-pass)
 * - Use a HashMap to store each number with its index
 * - For each number, check if its complement (target - num) exists in the map
 * - Time: O(n), Space: O(n)
 */
public class Problem001_TwoSum {
    public static void main(String[] args) {
        System.out.println("Running Problem001_TwoSum");
        int[] result = twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result)); // Output: [0, 1]
    }

    /**
     * Find two numbers that sum to target using hash map approach.
     * 
     * @param nums the input array of integers
     * @param target the target sum
     * @return indices of two numbers or [-1, -1] if not found
     */
static int[] twoSum(int[] nums, int target) {
        // Map to store value -> index mapping for O(1) lookup
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement needed to reach target
            int complement = target - nums[i];
            
            // If complement already seen, return indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Store current number and its index for future lookup
            map.put(nums[i], i);
        }
        
        return new int[] { -1, -1 }; // No solution found
    }
}
