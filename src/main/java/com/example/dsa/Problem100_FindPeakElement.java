package com.example.dsa;

/**
 * Problem 100: Find Peak Element
 *
 * Find a peak element in an array and return its index.
 *
 * Solution explanation in code comments.
 */
public class Problem100_FindPeakElement {
    public static void main(String[] args) {
        System.out.println("Running Problem100_FindPeakElement");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
