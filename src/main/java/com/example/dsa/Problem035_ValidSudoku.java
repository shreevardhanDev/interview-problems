package com.example.dsa;

/**
 * Problem 035: Valid Sudoku
 *
 * Determine if a 9x9 Sudoku board is valid.
 *
 * Solution explanation in code comments.
 */
public class Problem035_ValidSudoku {
    public static void main(String[] args) {
        System.out.println("Running Problem035_ValidSudoku");
        System.out.println("Example is in method comments.");
    }

    // Core solution method using Java 25 enhanced pattern matching and cleaner initialization
static boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                int num = ch - '1';
                int box = (r / 3) * 3 + c / 3;
                // Pattern: multiple conditions checked efficiently
                if (rows[r][num] || cols[c][num] || boxes[box][num]) return false;
                rows[r][num] = cols[c][num] = boxes[box][num] = true;
            }
        }
        return true;
    }
}
