package com.example.dsa;

/**
 * Problem 008: String to Integer (atoi)
 *
 * Convert a string to a 32-bit signed integer, handling whitespace, signs, and overflow.
 *
 * Solution explanation in code comments.
 */
public class Problem008_StringToInteger {
    public static void main(String[] args) {
        System.out.println("Running Problem008_StringToInteger");
        System.out.println(myAtoi("   -42"));
    }

    // Core solution method
static int myAtoi(String s) {
        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }
}
