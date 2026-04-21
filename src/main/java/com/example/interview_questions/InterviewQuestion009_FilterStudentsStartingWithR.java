package com.example.interview_questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Interview Question 009: Filter Students Starting with 'R'
 *
 * Given a list of student names, filter those starting with 'R'.
 *
 * Example:
 * Input: ["Ram", "Shyam", "Ravi", "John"]
 * Output: ["Ram", "Ravi"]
 *
 * Explanation: Use Java Streams to filter names starting with 'R'.
 */
public class InterviewQuestion009_FilterStudentsStartingWithR {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion009_FilterStudentsStartingWithR");
        List<String> students = Arrays.asList("Ram", "Shyam", "Ravi", "John");
        List<String> result = students.stream()
                .filter(name -> name.startsWith("R"))
                .collect(Collectors.toList());
        System.out.println(result); // Output: [Ram, Ravi]
    }
}