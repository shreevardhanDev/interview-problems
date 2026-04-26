package com.example.interview_questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Interview Question 052: Group Strings by Length
 *
 * Given a list of strings, group them by their length.
 *
 * Example 1:
 * Input: ["apple", "banana", "cat", "dog", "elephant"]
 * Output: {3=[cat, dog], 5=[apple], 6=[banana], 8=[elephant]}
 *
 * Example 2:
 * Input: ["a", "bb", "ccc", "dd", "eee"]
 * Output: {1=[a], 2=[bb, dd], 3=[ccc, eee]}
 *
 * Approach: Stream groupingBy
 * - Group by string length
 * - Collect into Map<Integer, List<String>>
 * - Time: O(n), Space: O(n)
 */
public class InterviewQuestion052_GroupStringsByLength {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion052_GroupStringsByLength");
        
        List<String> words1 = Arrays.asList("apple", "banana", "cat", "dog", "elephant");
        Map<Integer, List<String>> result1 = groupByLength(words1);
        System.out.println("Input: " + words1);
        System.out.println("Output: " + result1);
        
        List<String> words2 = Arrays.asList("a", "bb", "ccc", "dd", "eee");
        Map<Integer, List<String>> result2 = groupByLength(words2);
        System.out.println("\nInput: " + words2);
        System.out.println("Output: " + result2);
        
        List<String> words3 = Arrays.asList("hello", "world", "java", "streams", "are", "great");
        Map<Integer, List<String>> result3 = groupByLength(words3);
        System.out.println("\nInput: " + words3);
        System.out.println("Output: " + result3);
    }

    /**
     * Group strings by their length using streams.
     *
     * @param words list of strings to group
     * @return map of length to list of strings
     */
    static Map<Integer, List<String>> groupByLength(List<String> words) {
        return words.stream()
            .collect(Collectors.groupingBy(String::length));
    }
}
