package com.example.dsa;

/**
 * Problem 043: Jump Game
 *
 * Determine if you can reach the last index of the array.
 *
 * Solution explanation in code comments.
 */
public class Problem043_JumpGame {
    public static void main(String[] args) {
        System.out.println("Running Problem043_JumpGame");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
