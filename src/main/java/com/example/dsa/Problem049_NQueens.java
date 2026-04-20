package com.example.dsa;

/**
 * Problem 049: N-Queens
 *
 * Return all distinct solutions to the N-Queens problem.
 *
 * Solution explanation in code comments.
 */
public class Problem049_NQueens {
    public static void main(String[] args) {
        System.out.println("Running Problem049_NQueens");
        System.out.println("Example is in method comments.");
    }

    // Core solution method using Java 25 modern collection patterns
static java.util.List<java.util.List<String>> solveNQueens(int n) {
        java.util.List<java.util.List<String>> result = new java.util.ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) java.util.Arrays.fill(board[i], '.');
        backtrackNQueens(result, board, 0);
        return java.util.List.copyOf(result.stream().map(java.util.List::copyOf).toList());
    }
    private static void backtrackNQueens(java.util.List<java.util.List<String>> result, char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            java.util.List<String> solution = new java.util.ArrayList<>();
            for (char[] line : board) solution.add(new String(line));
            result.add(solution);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValidNQueens(board, row, col)) {
                board[row][col] = 'Q';
                backtrackNQueens(result, board, row + 1);
                board[row][col] = '.';
            }
        }
    }
    private static boolean isValidNQueens(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
