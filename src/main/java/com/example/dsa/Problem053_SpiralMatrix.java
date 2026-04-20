package com.example.dsa;

/**
 * Problem 053: Spiral Matrix
 *
 * Return all elements of a matrix in spiral order.
 *
 * Solution explanation in code comments.
 */
public class Problem053_SpiralMatrix {
    public static void main(String[] args) {
        System.out.println("Running Problem053_SpiralMatrix");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static java.util.List<Integer> spiralOrder(int[][] matrix) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (matrix.length == 0) return result;
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) result.add(matrix[top][j]);
            top++;
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) result.add(matrix[bottom][j]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }
}
