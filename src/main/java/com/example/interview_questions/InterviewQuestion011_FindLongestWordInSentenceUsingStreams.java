package com.example.interview_questions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Interview Question 011: Find the Longest Word in a Sentence Using Java Streams
 *
 * Given a sentence, find the longest word.
 *
 * Example:
 * Input: "The quick brown fox jumps over the lazy dog"
 * Output: "jumps"
 *
 * Explanation: Use streams to split and find max by length.
 */
public class InterviewQuestion011_FindLongestWordInSentenceUsingStreams {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion011_FindLongestWordInSentenceUsingStreams");
        String sentence = "The quick brown fox jumps over the lazy dog";
        String result = Arrays.stream(sentence.split(" "))
                .filter(s -> !s.isEmpty())
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println(result); // Output: jumps
    }
}