package com.example.dsa;

/**
 * Problem 046: Rotate Image
 *
 * Rotate an n x n matrix by 90 degrees clockwise in-place.
 *
 * Solution explanation in code comments.
 */
public class Problem046_RotateImage {
    public static void main(String[] args) {
        System.out.println("Running Problem046_RotateImage");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
