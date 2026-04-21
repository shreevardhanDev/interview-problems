package com.example.interview_questions;

/**
 * Interview Question 013: SQL: Select Upper Case First Name with Alias STUDENT_NAME
 *
 * Write a SQL query to select the upper case of first_name with alias STUDENT_NAME.
 *
 * Example:
 * SELECT UPPER(first_name) AS STUDENT_NAME FROM students;
 *
 * Explanation: Use UPPER() function and AS for alias.
 */
public class InterviewQuestion013_SQLSelectUpperCaseFirstName {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion013_SQLSelectUpperCaseFirstName");
        String query = "SELECT UPPER(first_name) AS STUDENT_NAME FROM students;";
        System.out.println("SQL Query: " + query);
    }
}