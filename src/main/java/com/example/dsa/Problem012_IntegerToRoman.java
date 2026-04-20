package com.example.dsa;

/**
 * Problem 012: Integer to Roman
 *
 * Convert an integer to its Roman numeral representation.
 *
 * Approach: Greedy Substitution from Largest to Smallest
 * - Use array of values and symbols in decreasing order
 * - Include subtraction cases (4=IV, 9=IX, 40=XL, etc.)
 * - Greedily use largest possible symbol for remaining value
 * - Time: O(1) [values fixed], Space: O(1) [result at most 4000 chars]
 */
public class Problem012_IntegerToRoman {
    // Constants for value-symbol pairs in decreasing order
    // Includes subtractive notation (e.g., 900 for CM, 400 for CD)
    private static final int[] VALUES = {
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };
    private static final String[] SYMBOLS = {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    public static void main(String[] args) {
        System.out.println("Running Problem012_IntegerToRoman");
        System.out.println(intToRoman(58));   // Output: LVIII
        System.out.println(intToRoman(1994)); // Output: MCMXCIV
    }

    /**
     * Convert integer to Roman numeral representation.
     * 
     * @param num the integer to convert (1-3999)
     * @return the Roman numeral string
     */
static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        
        // Greedily use largest possible value at each step
        for (int i = 0; i < VALUES.length; i++) {
            // While remaining value >= current symbol value
            while (num >= VALUES[i]) {
                // Subtract value and append symbol
                num -= VALUES[i];
                result.append(SYMBOLS[i]);
            }
        }
        
        return result.toString();
    }
}
