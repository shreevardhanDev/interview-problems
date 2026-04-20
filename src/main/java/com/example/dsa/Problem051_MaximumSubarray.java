package com.example.dsa;

/**
 * Problem 051: Maximum Subarray
 *
 * Find the contiguous subarray with the largest sum.
 *
 * Approach: Kadane's Algorithm (Dynamic Programming)
 * - Track maximum sum ending at current position
 * - At each position: decide whether to extend previous subarray or start new
 * - Keep track of global maximum
 * - Time: O(n), Space: O(1)
 */
public class Problem051_MaximumSubarray {
    public static void main(String[] args) {
        System.out.println("Running Problem051_MaximumSubarray");
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums)); // Output: 6 ([4, -1, 2, 1])
    }

    /**
     * Find maximum sum of any contiguous subarray.
     * Implements Kadane's algorithm for O(n) time complexity.
     * 
     * @param nums the array of integers
     * @return maximum subarray sum
     */
static int maxSubArray(int[] nums) {
        // maxEndingHere: max sum ending at current position
        int maxEndingHere = nums[0];
        // maxSoFar: global maximum found
        int maxSoFar = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Either extend current subarray or start fresh from current element
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            
            // Update global maximum
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
}
