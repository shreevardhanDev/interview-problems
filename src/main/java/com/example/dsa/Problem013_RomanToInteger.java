package com.example.dsa;

import java.util.Map;

/**
 * Problem 013: Roman to Integer
 *
 * Convert a Roman numeral into an integer.
 *
 * Approach: Map with Lookahead
 * - Use Map to store Roman numeral values
 * - Check if current numeral is less than next (subtractive case like IV, IX)
 * - Time: O(n), Space: O(1) [fixed 7 symbols]
 */
public class Problem013_RomanToInteger {
    public static void main(String[] args) {
        System.out.println("Running Problem013_RomanToInteger");
        System.out.println(romanToInt("MCMXCIV")); // Output: 1994
    }

    /**
     * Convert Roman numeral string to integer value.
     * Handles subtractive notation (IV=4, IX=9, XL=40, XC=90, CD=400, CM=900)
     * 
     * @param s the Roman numeral string
     * @return the integer value
     */
static int romanToInt(String s) {
        // Map Roman symbols to their integer values (Java 25 immutable map)
        Map<Character, Integer> values = Map.ofEntries(
            Map.entry('I', 1),   Map.entry('V', 5),
            Map.entry('X', 10),  Map.entry('L', 50),
            Map.entry('C', 100), Map.entry('D', 500),
            Map.entry('M', 1000)
        );
        
        int total = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Integer value = values.get(s.charAt(i));
            
            // Handle subtractive cases (smaller before larger: IV, IX, XL, XC, CD, CM)
            if (value != null && i + 1 < s.length()) {
                Integer nextValue = values.get(s.charAt(i + 1));
                if (nextValue != null && value < nextValue) {
                    // Subtract current value as it's before a larger value
                    total -= value;
                    continue;
                }
            }
            
            // Add value for normal cases or smaller numerals
            if (value != null) total += value;
        }
        return total;
    }
}
