package com.example.interview_questions;

/**
 * Interview Question 020: Highest Paid Employee by Department
 *
 * Write a SQL query to find the highest paid employee in each department.
 *
 * Example:
 * SELECT d.name AS department, e.name AS employee, e.salary
 * FROM employee e
 * JOIN department d ON e.department_id = d.id
 * WHERE (e.department_id, e.salary) IN (
 *     SELECT department_id, MAX(salary)
 *     FROM employee
 *     GROUP BY department_id
 * );
 *
 * Explanation: Use subquery to find max salary per department.
 */
public class InterviewQuestion020_HighestPaidEmployeeByDepartment {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion020_HighestPaidEmployeeByDepartment");
        String query = "SELECT d.name AS department, e.name AS employee, e.salary " +
                       "FROM employee e " +
                       "JOIN department d ON e.department_id = d.id " +
                       "WHERE (e.department_id, e.salary) IN (" +
                       "    SELECT department_id, MAX(salary) " +
                       "    FROM employee " +
                       "    GROUP BY department_id" +
                       ");";
        System.out.println("SQL Query: " + query);
    }
}