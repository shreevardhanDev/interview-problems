package com.example.dsa;

/**
 * Problem 065: Climbing Stairs
 *
 * Count distinct ways to climb n stairs taking 1 or 2 steps.
 *
 * Solution explanation in code comments.
 */
public class Problem065_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println("Running Problem065_ClimbingStairs");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
