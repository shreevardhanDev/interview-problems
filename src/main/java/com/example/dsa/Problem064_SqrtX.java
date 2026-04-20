package com.example.dsa;

/**
 * Problem 064: Sqrt(x)
 *
 * Compute the integer square root of x.
 *
 * Solution explanation in code comments.
 */
public class Problem064_SqrtX {
    public static void main(String[] args) {
        System.out.println("Running Problem064_SqrtX");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int mySqrt(int x) {
        long left = 0, right = x, ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
    }
}
