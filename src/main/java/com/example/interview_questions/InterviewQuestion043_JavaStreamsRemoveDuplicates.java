package com.example.interview_questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Interview Question 043: Java Streams: Remove Duplicates and Find Unique Elements
 * Use distinct() to remove duplicates.
 * Example: list.stream().distinct().collect(Collectors.toList());
 */
public class InterviewQuestion043_JavaStreamsRemoveDuplicates {
    static void main() {
        System.out.println("Running InterviewQuestion043_JavaStreamsRemoveDuplicates");
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 3);
        List<Integer> unique = list.stream().distinct().collect(Collectors.toList());
        System.out.println(unique); // [1,2,3]
    }
}