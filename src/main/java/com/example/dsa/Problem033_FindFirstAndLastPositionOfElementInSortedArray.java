package com.example.dsa;

/**
 * Problem 033: Find First and Last Position of Element in Sorted Array
 *
 * Return the starting and ending position of a given target in a sorted array.
 *
 * Solution explanation in code comments.
 */
public class Problem033_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        System.out.println("Running Problem033_FindFirstAndLastPositionOfElementInSortedArray");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int[] searchRange(int[] nums, int target) {
        return new int[] { findBoundary(nums, target, true), findBoundary(nums, target, false) };
    }
    private static int findBoundary(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1, boundary = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                boundary = mid;
                if (findFirst) right = mid - 1;
                else left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return boundary;
    }
}
