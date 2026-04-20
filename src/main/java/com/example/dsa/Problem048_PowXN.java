package com.example.dsa;

/**
 * Problem 048: Pow(x, n)
 *
 * Implement x raised to the power n. Compute x^n efficiently using binary exponentiation.
 *
 * Solution explanation in code comments.
 */
public class Problem048_PowXN {
    public static void main(String[] args) {
        System.out.println("Running Problem048_PowXN");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static double myPow(double x, int n) {
        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }
        double result = 1;
        while (power > 0) {
            if ((power & 1) == 1) result *= x;
            x *= x;
            power >>= 1;
        }
        return result;
    }
}
