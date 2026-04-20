package com.example.dsa;

/**
 * Problem 039: First Missing Positive
 *
 * Find the smallest missing positive integer in an unsorted array in O(n) time and O(1) space.
 *
 * Solution explanation in code comments.
 */
public class Problem039_FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println("Running Problem039_FirstMissingPositive");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}
