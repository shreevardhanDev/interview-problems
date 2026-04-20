package com.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 015: 3Sum
 *
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Approach: Sort + Two Pointers
 * - Sort array to enable two-pointer technique
 * - Fix one element and find two others that sum to -element
 * - Skip duplicates to ensure unique triplets
 * - Time: O(n²), Space: O(1) [excluding output]
 */
public class Problem015_ThreeSum {
    public static void main(String[] args) {
        System.out.println("Running Problem015_ThreeSum");
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums)); // [[-1,-1,2], [-1,0,1]]
    }

    /**
     * Find all unique triplets that sum to zero.
     * 
     * @param nums the input array
     * @return list of unique triplets summing to zero
     */
static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort to enable two-pointer approach and duplicate skipping
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for outer loop
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // If smallest possible sum is positive, no zero-sum triplets exist
            if (nums[i] > 0) break;
            
            // Two-pointer search for remaining two numbers
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicate values for left pointer
                    left++; right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;  // Need larger sum
                } else {
                    right--; // Need smaller sum
                }
            }
        }
        
        return List.copyOf(result);
    }
}
