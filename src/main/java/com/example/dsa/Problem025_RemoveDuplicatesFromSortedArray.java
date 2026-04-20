package com.example.dsa;

/**
 * Problem 025: Remove Duplicates from Sorted Array
 *
 * Remove duplicates in-place from a sorted array and return the new length.
 *
 * Solution explanation in code comments.
 */
public class Problem025_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println("Running Problem025_RemoveDuplicatesFromSortedArray");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int writeIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[writeIndex - 1]) {
                nums[writeIndex++] = nums[i];
            }
        }
        return writeIndex;
    }
}
