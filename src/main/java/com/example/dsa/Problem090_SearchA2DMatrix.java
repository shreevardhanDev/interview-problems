package com.example.dsa;

/**
 * Problem 090: Search a 2D Matrix
 *
 * Search for a value in a matrix where each row is sorted and first element of each row is greater than last of previous row.
 *
 * Solution explanation in code comments.
 */
public class Problem090_SearchA2DMatrix {
    public static void main(String[] args) {
        System.out.println("Running Problem090_SearchA2DMatrix");
        System.out.println("Example is in method comments.");
    }

    // Core solution method using Java 25 switch expression for comparisons
static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = matrix[mid / n][mid % n];
            int comparison = Integer.compare(midVal, target);
            if (comparison == 0) return true;
            if (comparison < 0) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
