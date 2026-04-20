package com.example.dsa;

/**
 * Problem 028: Divide Two Integers
 *
 * Divide two integers without using multiplication, division, or mod operators.
 *
 * Solution explanation in code comments.
 */
public class Problem028_DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println("Running Problem028_DivideTwoIntegers");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int divide(int dividend, int divisor) {
        if (divisor == 0) throw new ArithmeticException("Division by zero");
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((dvd >> i) >= dvs) {
                result += 1 << i;
                dvd -= dvs << i;
            }
        }
        return ((dividend < 0) ^ (divisor < 0)) ? -result : result;
    }
}
