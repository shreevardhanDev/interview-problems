package com.example.interview_questions;

import java.util.*;

/**
 * Interview Question 057: Common Characters in Multiple Strings
 *
 * Find common characters that appear in all strings.
 *
 * Problem Statement:
 * Given an array of strings, return the common characters that appear in all strings.
 *
 * Example:
 * Input: ["flower", "flow", "flight"]
 * Output: [f, l, o]
 * Explanation: f, l, o are common in all three strings
 *
 * Algorithm:
 * - Use Set intersection approach
 * - Start with first string's characters
 * - For each subsequent string, retain only common characters
 * - Use Set.retainAll() for intersection
 * - Time Complexity: O(n*m) where n is number of strings, m is string length
 * - Space Complexity: O(1) since alphabet is limited (26 chars)
 */
public class InterviewQuestion057_CommonCharactersInMultipleStrings {
    public static void main(String[] args) {
        System.out.println("=== Common Characters in Multiple Strings ===\n");

        // Test Case 1
        String[] strings1 = {"flower", "flow", "flight"};
        System.out.println("Input: " + Arrays.toString(strings1));
        System.out.println("Output: " + findCommonCharacters(strings1));
        System.out.println("Expected: [f, l, o]\n");

        // Test Case 2
        String[] strings2 = {"leetcode", "leet", "lead"};
        System.out.println("Input: " + Arrays.toString(strings2));
        System.out.println("Output: " + findCommonCharacters(strings2));
        System.out.println("Expected: [e, l]\n");

        // Test Case 3
        String[] strings3 = {"abc", "def"};
        System.out.println("Input: " + Arrays.toString(strings3));
        System.out.println("Output: " + findCommonCharacters(strings3));
        System.out.println("Expected: []\n");

        // Test Case 4
        String[] strings4 = {"aaa", "aaa", "aaa"};
        System.out.println("Input: " + Arrays.toString(strings4));
        System.out.println("Output: " + findCommonCharacters(strings4));
        System.out.println("Expected: [a]\n");

        // Detailed Example
        System.out.println("=== Detailed Breakdown ===");
        findCommonCharactersDetailed(new String[]{"flower", "flow", "flight"});
    }

    static List<Character> findCommonCharacters(String[] strings) {
        Set<Character> commonChars = new HashSet<>();

        for (char c : strings[0].toCharArray()) {
            commonChars.add(c);
        }

        for (int i = 1; i < strings.length; i++) {
            Set<Character> currentChars = new HashSet<>();
            for (char c : strings[i].toCharArray()) {
                currentChars.add(c);
            }
            commonChars.retainAll(currentChars);
        }

        List<Character> result = new ArrayList<>(commonChars);
        Collections.sort(result);
        return result;
    }

    static void findCommonCharactersDetailed(String[] strings) {
        System.out.println("Strings: " + Arrays.toString(strings));

        Set<Character> commonChars = new HashSet<>();
        for (char c : strings[0].toCharArray()) {
            commonChars.add(c);
        }
        System.out.println("Initial common (from first string): " + commonChars);

        for (int i = 1; i < strings.length; i++) {
            Set<Character> currentChars = new HashSet<>();
            for (char c : strings[i].toCharArray()) {
                currentChars.add(c);
            }
            System.out.println("Characters in \"" + strings[i] + "\": " + currentChars);
            commonChars.retainAll(currentChars);
            System.out.println("Common after intersection: " + commonChars);
        }

        List<Character> result = new ArrayList<>(commonChars);
        Collections.sort(result);
        System.out.println("\nFinal Common Characters (sorted): " + result);
    }
}
