package com.example.dsa;

/**
 * Problem 006: ZigZag Conversion
 *
 * Convert a string to a zigzag pattern on a given number of rows, then read line by line.
 *
 * Solution explanation in code comments.
 */
public class Problem006_ZigzagConversion {
    public static void main(String[] args) {
        System.out.println("Running Problem006_ZigzagConversion");
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    // Core solution method
static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();
        int currentRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0 || currentRow == numRows - 1) goingDown = !goingDown;
            currentRow += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) result.append(row);
        return result.toString();
    }
}
