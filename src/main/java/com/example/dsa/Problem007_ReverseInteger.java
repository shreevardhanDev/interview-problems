package com.example.dsa;

/**
 * Problem 007: Reverse Integer
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * Example 1:
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 * Input: x = 120
 * Output: 21
 *
 * Constraints:
 * - -2^31 <= x <= 2^31 - 1
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
            x = x / 10;
            result = result * 10 + digit;
        }
        return result;
    }
}
