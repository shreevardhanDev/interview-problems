package com.example.interview_questions;

/**
 * Interview Question 045: Fibonacci Sequence
 *
 * Generate Fibonacci sequence up to n.
 *
 * Example: 0, 1, 1, 2, 3, 5...
 */
public class InterviewQuestion045_FibonacciSequence {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion045_FibonacciSequence");
        int n = 10;
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
    }

    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}