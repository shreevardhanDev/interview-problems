package com.example.dsa;

import java.util.Arrays;

/**
 * Problem 016: 3Sum Closest
 *
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 *
 * Constraints:
 * - 3 <= nums.length <= 1000
 * - -1000 <= nums[i] <= 1000
 * - -10^4 <= target <= 10^4
 *
 * Approach: Sort + Two Pointers with Distance Tracking
 * - Sort array for two-pointer technique
 * - Track closest sum seen so far with minimum distance to target
 * - Adjust pointers based on current sum vs target
 * - Time: O(n²), Space: O(1)
 */
public class Problem016_ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println("Running Problem016_ThreeSumClosest");
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1)); // Output: 2
    }

    /**
     * Find three numbers whose sum is closest to the target.
     * 
     * @param nums the input array
     * @param target the target sum
     * @return the sum of three numbers closest to target
     */
    static int threeSumClosest(int[] nums, int target) {
        // Sort to enable two-pointer approach
        Arrays.sort(nums);
        
        // Initialize with first three elements
        int closest = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Two-pointer search for best pair
            int left = i + 1, right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // Update closest if current sum is closer to target
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                
                // Move pointers based on sum vs target
                if (sum < target) {
                    left++;  // Need larger sum
                } else {
                    right--; // Need smaller sum
                }
            }
        }
        
        return closest;
    }
}
