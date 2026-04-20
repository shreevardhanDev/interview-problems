package com.example.dsa;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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
    static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        backtrackNQueens(result, board, 0);
        return List.copyOf(result.stream().map(List::copyOf).toList());
    }
    private static void backtrackNQueens(List<List<String>> result, char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            List<String> solution = new ArrayList<>();
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
