package com.example.interview_questions;

/**
 * Interview Question 042: SQL: Case Statement for 1 to 0 and 0 to 1
 *
 * SELECT CASE WHEN status = 1 THEN 0 ELSE 1 END AS new_status FROM table;
 *
 * Explanation: Use CASE for conditional logic.
 */
public class InterviewQuestion042_SQLCaseStatement {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion042_SQLCaseStatement");
        String query = "SELECT CASE WHEN status = 1 THEN 0 ELSE 1 END AS new_status FROM table;";
        System.out.println("SQL Query: " + query);
        // In a real application, use JDBC to execute this query.
    }
}