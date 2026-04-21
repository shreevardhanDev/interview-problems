package com.example.interview_questions;

/**
 * Interview Question 040: Employee Join Date Queries
 *
 * Example SQL: SELECT * FROM employee WHERE join_date >= '2023-01-01';
 *
 * Explanation: Use date functions for filtering.
 */
public class InterviewQuestion040_EmployeeJoinDateQueries {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion040_EmployeeJoinDateQueries");
        String query = "SELECT * FROM employee WHERE join_date >= '2023-01-01';";
        System.out.println("SQL Query: " + query);
        // In a real application, use JDBC to execute this query.
        // Example: Connection conn = DriverManager.getConnection(url, user, pass);
        // PreparedStatement stmt = conn.prepareStatement(query);
        // ResultSet rs = stmt.executeQuery();
    }
}