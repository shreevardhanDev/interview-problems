package com.example.dsa;

/**
 * Problem 060: Valid Number
 *
 * Validate if a string can be interpreted as a decimal number.
 *
 * Solution explanation in code comments.
 */
public class Problem060_ValidNumber {
    public static void main(String[] args) {
        System.out.println("Running Problem060_ValidNumber");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty()) return false;
        boolean hasDigit = false, hasDot = false, hasExp = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else if (c == '.') {
                if (hasDot || hasExp) return false;
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (hasExp || !hasDigit) return false;
                hasExp = true;
                hasDigit = false;
            } else {
                return false;
            }
        }
        return hasDigit;
    }
}
