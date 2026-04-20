package com.example.dsa;

/**
 * Problem 089: Find Minimum in Rotated Sorted Array
 *
 * Find the minimum element in a rotated sorted array.
 *
 * Solution explanation in code comments.
 */
public class Problem089_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println("Running Problem089_FindMinimumInRotatedSortedArray");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}
