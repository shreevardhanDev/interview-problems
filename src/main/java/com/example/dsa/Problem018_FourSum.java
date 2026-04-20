package com.example.dsa;

/**
 * Problem 018: 4Sum
 *
 * Find unique quadruplets in the array that sum up to the target.
 *
 * Solution explanation in code comments.
 */
public class Problem018_FourSum {
    public static void main(String[] args) {
        System.out.println("Running Problem018_FourSum");
        System.out.println("Example is in method comments.");
    }

    // Core solution method using Java 25 modern collection patterns
static java.util.List<java.util.List<Integer>> fourSum(int[] nums, int target) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        java.util.Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(java.util.List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++; right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return java.util.List.copyOf(result);
    }
}
