package com.example.dsa;

/**
 * Problem 050: N-Queens II
 *
 * Return the number of distinct N-Queens solutions.
 *
 * Solution explanation in code comments.
 */
public class Problem050_NQueensII {
    public static void main(String[] args) {
        System.out.println("Running Problem050_NQueensII");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int totalNQueens(int n) {
        return solveNQueensCount(0, n, 0, 0, 0);
    }
    private static int solveNQueensCount(int row, int n, int columns, int diagonals1, int diagonals2) {
        if (row == n) return 1;
        int count = 0;
        int available = ((1 << n) - 1) & ~(columns | diagonals1 | diagonals2);
        while (available != 0) {
            int position = available & -available;
            available -= position;
            count += solveNQueensCount(row + 1, n, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
        }
        return count;
    }
}
