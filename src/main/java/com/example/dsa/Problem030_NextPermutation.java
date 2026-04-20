package com.example.dsa;

/**
 * Problem 030: Next Permutation
 *
 * Rearrange numbers into the lexicographically next greater permutation.
 *
 * Solution explanation in code comments.
 */
public class Problem030_NextPermutation {
    public static void main(String[] args) {
        System.out.println("Running Problem030_NextPermutation");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    private static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) swap(nums, left++, right--);
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
