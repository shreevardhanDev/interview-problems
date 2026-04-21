package com.example.interview_questions;

/**
 * Interview Question 017: Print Even Numbers up to 20 with 1-Second Delay Using Thread
 *
 * Print even numbers from 2 to 20 with 1 second delay between each.
 *
 * Explanation: Use a loop with Thread.sleep(1000).
 */
public class InterviewQuestion017_PrintEvenNumbersWithDelay {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion017_PrintEvenNumbersWithDelay");
        for (int i = 2; i <= 20; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}