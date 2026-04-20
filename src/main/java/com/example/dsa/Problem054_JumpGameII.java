package com.example.dsa;

/**
 * Problem 054: Jump Game II
 *
 * Return the minimum number of jumps to reach the last index.
 *
 * Solution explanation in code comments.
 */
public class Problem054_JumpGameII {
    public static void main(String[] args) {
        System.out.println("Running Problem054_JumpGameII");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}
