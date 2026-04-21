package com.example.interview_questions;

/**
 * Interview Question 041: SQL: Select Employees Joined in Last 90 Days
 *
 * SELECT * FROM employee WHERE join_date >= DATE_SUB(CURDATE(), INTERVAL 90 DAY);
 *
 * Explanation: Use DATE_SUB for date arithmetic.
 */
public class InterviewQuestion041_SQLSelectEmployeesJoinedInLast90Days {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion041_SQLSelectEmployeesJoinedInLast90Days");
        String query = "SELECT * FROM employee WHERE join_date >= DATE_SUB(CURDATE(), INTERVAL 90 DAY);";
        System.out.println("SQL Query: " + query);
        // In a real application, use JDBC to execute this query.
    }
}