package com.example.interview_questions;

/**
 * Interview Question 051: Sum of Unique Character Lengths in Substrings
 *
 * Given a string, find the sum of lengths of all substrings with all unique characters.
 *
 * Problem Statement:
 * For each substring with all unique characters, add its length to the result.
 *
 * Example:
 * Input: "AABCDCC"
 * Output: Sum of lengths of all unique character substrings
 * Substrings with unique chars: "A"(1), "AB"(2), "ABC"(3), "ABCD"(4), "B"(1), "BC"(2), "BCD"(3), "C"(1), "D"(1)
 *
 * Algorithm:
 * - Use nested loops to generate all substrings
 * - For each substring, check if all characters are unique
 * - Use HashSet to track unique characters
 * - Time Complexity: O(n^3) or O(n^2) with optimization
 * - Space Complexity: O(min(n, 26)) for character set
 */
public class InterviewQuestion051_SumOfUniqueCharLengthsInSubstrings {
    public static void main(String[] args) {
        System.out.println("=== Sum of Unique Character Lengths in Substrings ===\n");

        // Test Case 1
        String s1 = "AABCDCC";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + sumOfUniqueCharLengths(s1) + "\n");

        // Test Case 2
        String s2 = "ABC";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + sumOfUniqueCharLengths(s2) + "\n");

        // Test Case 3
        String s3 = "ABAB";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + sumOfUniqueCharLengths(s3) + "\n");

        // Test Case 4
        String s4 = "A";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: " + sumOfUniqueCharLengths(s4) + "\n");

        // Detailed Example
        String test = "AABCDCC";
        System.out.println("=== Detailed Breakdown for \"" + test + "\" ===");
        findAndPrintUniqueSubstrings(test);
    }

    static int sumOfUniqueCharLengths(String s) {
        int sum = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            java.util.Set<Character> uniqueChars = new java.util.HashSet<>();
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (uniqueChars.contains(c)) {
                    break;
                }
                uniqueChars.add(c);
                sum += (j - i + 1);
            }
        }

        return sum;
    }

    static void findAndPrintUniqueSubstrings(String s) {
        int totalSum = 0;
        int n = s.length();
        System.out.println("Substrings with all unique characters:");

        for (int i = 0; i < n; i++) {
            java.util.Set<Character> uniqueChars = new java.util.HashSet<>();
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (uniqueChars.contains(c)) {
                    break;
                }
                uniqueChars.add(c);
                String substring = s.substring(i, j + 1);
                int length = j - i + 1;
                System.out.println("  \"" + substring + "\" (length: " + length + ")");
                totalSum += length;
            }
        }
        System.out.println("Total Sum: " + totalSum + "\n");
    }
}
