package com.example.interview_questions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Interview Question 044: Java Streams: Group by Count and Find Non-Repeating
 *
 * Group by element and count, then filter where count == 1.
 */
public class InterviewQuestion044_JavaStreamsGroupByCount {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion044_JavaStreamsGroupByCount");
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        Map<Integer, Long> freq = list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        List<Integer> nonRepeating = freq.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(nonRepeating); // [1,4]
    }
}