package com.example.dsa;

/**
 * Problem 041: Multiply Strings
 *
 * Multiply two non-negative integers represented as strings and return the product as a string.
 *
 * Solution explanation in code comments.
 */
public class Problem041_MultiplyStrings {
    public static void main(String[] args) {
        System.out.println("Running Problem041_MultiplyStrings");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
