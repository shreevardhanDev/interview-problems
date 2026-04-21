package com.example.interview_questions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Interview Question 015: Group Words by Length Frequency
 *
 * Given a list of words, group them by length and count frequency.
 *
 * Example:
 * Input: ["a", "bb", "c", "dd", "eee"]
 * Output: {1=2, 2=2, 3=1}
 *
 * Explanation: Use streams to group by length and count.
 */
public class InterviewQuestion015_GroupWordsByLengthFrequency {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion015_GroupWordsByLengthFrequency");
        List<String> words = Arrays.asList("a", "bb", "c", "dd", "eee");
        Map<Integer, Long> result = words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(result); // Output: {1=2, 2=2, 3=1}
    }
}