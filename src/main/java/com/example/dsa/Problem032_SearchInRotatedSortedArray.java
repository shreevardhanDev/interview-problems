package com.example.dsa;

/**
 * Problem 032: Search in Rotated Sorted Array
 *
 * Search a target in a rotated sorted array and return its index or -1 if not found.
 *
 * Solution explanation in code comments.
 */
public class Problem032_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println("Running Problem032_SearchInRotatedSortedArray");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
