package com.example.interview_questions;

/**
 * Interview Question 014: SQL: Left Outer Join Student and Course
 *
 * Write a SQL query to perform left outer join between student and course tables.
 *
 * Example:
 * SELECT s.name, c.title FROM student s LEFT OUTER JOIN course c ON s.id = c.student_id;
 *
 * Explanation: Use LEFT OUTER JOIN to include all students even if no courses.
 */
public class InterviewQuestion014_SQLLeftOuterJoinStudentCourse {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion014_SQLLeftOuterJoinStudentCourse");
        String query = "SELECT s.name, c.title FROM student s LEFT OUTER JOIN course c ON s.id = c.student_id;";
        System.out.println("SQL Query: " + query);
    }
}