package com.example.dsa;

/**
 * Problem 036: Sudoku Solver
 *
 * Solve a Sudoku puzzle by filling empty cells.
 *
 * Solution explanation in code comments.
 */
public class Problem036_SudokuSolver {
    public static void main(String[] args) {
        System.out.println("Running Problem036_SudokuSolver");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static void solveSudoku(char[][] board) {
        solve(board);
    }
    private static boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char d = '1'; d <= '9'; d++) {
                        if (isSafe(board, r, c, d)) {
                            board[r][c] = d;
                            if (solve(board)) return true;
                            board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isSafe(char[][] board, int row, int col, char d) {
        int blockRow = (row / 3) * 3;
        int blockCol = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == d || board[i][col] == d) return false;
            if (board[blockRow + i / 3][blockCol + i % 3] == d) return false;
        }
        return true;
    }
}
