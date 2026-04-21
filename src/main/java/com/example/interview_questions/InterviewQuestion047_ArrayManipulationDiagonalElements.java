package com.example.interview_questions;

/**
 * Interview Question 047: Array Manipulation for Diagonal Elements
 *
 * For a 2D array, sum the main diagonal.
 *
 * Example: int[][] arr = {{1,2,3},{4,5,6},{7,8,9}}; sum = 1+5+9 = 15
 */
public class InterviewQuestion047_ArrayManipulationDiagonalElements {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion047_ArrayManipulationDiagonalElements");
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        System.out.println(sum); // 15
    }
}