package com.example.interview_questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Interview Question 054: Remove Adjacent Duplicates - StringBuilder
 *
 * Given a string, remove all adjacent duplicate characters.
 *
 * Example 1:
 * Input: "abbaca"
 * Output: "ca"
 * Explanation: "abbaca" -> "aaca" -> "ca"
 *
 * Example 2:
 * Input: "azxxzy"
 * Output: "ay"
 * Explanation: "azxxzy" -> "azzy" -> "ay"
 *
 * Example 3:
 * Input: "aabbcc"
 * Output: ""
 * Explanation: "aabbcc" -> "aacc" -> "cc" -> ""
 *
 * Approach: StringBuilder as Stack
 * - Use StringBuilder to simulate stack behavior
 * - For each character, check if it matches the last character in StringBuilder
 * - If match, remove last character; else append
 * - Time: O(n), Space: O(n)
 */
public class InterviewQuestion054_RemoveAdjacentDuplicatesStringBuilder {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion054_RemoveAdjacentDuplicatesStringBuilder");
        
        String test1 = "abbaca";
        String result1 = removeAdjacentDuplicates(test1);
        System.out.println("Input: \"" + test1 + "\"");
        System.out.println("Output: \"" + result1 + "\""); // "ca"
        
        String test2 = "azxxzy";
        String result2 = removeAdjacentDuplicates(test2);
        System.out.println("\nInput: \"" + test2 + "\"");
        System.out.println("Output: \"" + result2 + "\""); // "ay"
        
        String test3 = "aabbcc";
        String result3 = removeAdjacentDuplicates(test3);
        System.out.println("\nInput: \"" + test3 + "\"");
        System.out.println("Output: \"" + result3 + "\""); // ""
        
        String test4 = "abcde";
        String result4 = removeAdjacentDuplicates(test4);
        System.out.println("\nInput: \"" + test4 + "\"");
        System.out.println("Output: \"" + result4 + "\""); // "abcde"
    }

    /**
     * Remove adjacent duplicate characters using StringBuilder.
     *
     * @param s the input string
     * @return string with adjacent duplicates removed
     */
    static String removeAdjacentDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            // If StringBuilder is not empty and last character matches current
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1); // Remove last character
            } else {
                sb.append(c); // Add current character
            }
        }
        
        return sb.toString();
    }
}
