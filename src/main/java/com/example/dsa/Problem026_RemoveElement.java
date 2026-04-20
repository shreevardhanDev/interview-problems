package com.example.dsa;

/**
 * Problem 026: Remove Element
 *
 * Remove all instances of a given value in-place and return the new length.
 *
 * Solution explanation in code comments.
 */
public class Problem026_RemoveElement {
    public static void main(String[] args) {
        System.out.println("Running Problem026_RemoveElement");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int removeElement(int[] nums, int val) {
        int writeIndex = 0;
        for (int num : nums) {
            if (num != val) {
                nums[writeIndex++] = num;
            }
        }
        return writeIndex;
    }
}
