package com.example.interview_questions;

import java.util.Arrays;

/**
 * Interview Question 021: Smallest Lexicographical Pair in String
 *
 * Given a string, find the smallest lexicographical pair of characters.
 *
 * Example:
 * Input: "abc"
 * Output: "ab"
 *
 * Explanation: Sort the string and take first two.
 */
public class InterviewQuestion021_SmallestLexicographicalPairInString {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion021_SmallestLexicographicalPairInString");
        String s = "abc";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String result = "" + chars[0] + chars[1];
        System.out.println(result); // Output: ab
    }
}