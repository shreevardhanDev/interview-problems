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
        System.out.println(threeSum(nums, 0)); // [[-1,-1,2], [-1,0,1]]
    }

    /**
     * Find all unique triplets that sum to zero.
     * 
     * @param nums the input array
     * @return list of unique triplets summing to zero
     */
    static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Remove the target == 0 specific shortcut
            // Don't do: if (nums[i] > 0) break; → not valid for arbitrary target

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < target) {
                    left++;  // Need larger sum
                } else {
                    right--; // Need smaller sum
                }
            }
        }

        return List.copyOf(result);
    }
}
