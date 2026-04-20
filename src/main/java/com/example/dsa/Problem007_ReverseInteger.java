package com.example.dsa;

/**
 * Problem 007: Reverse Integer
 *
 * Reverse digits of an integer, handling overflow by returning 0 if it overflows.
 *
 * Solution explanation in code comments.
 */
public class Problem007_ReverseInteger {
    public static void main(String[] args) {
        System.out.println("Running Problem007_ReverseInteger");
        System.out.println(reverse(123));
    }

    // Core solution method
static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            result = result * 10 + digit;
        }
        return result;
    }
}
