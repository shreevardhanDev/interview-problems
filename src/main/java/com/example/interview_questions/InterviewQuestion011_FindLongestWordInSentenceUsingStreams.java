package com.example.interview_questions;

import java.util.Arrays;

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
        String result = Arrays.stream(sentence.split("\\s+"))
                .max((a, b) -> Integer.compare(a.length(), b.length()))
                .orElse("");
        System.out.println(result); // Output: jumps
    }
}