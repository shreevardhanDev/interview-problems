package com.example.interview_questions;

import java.util.Stack;

/**
 * Interview Question 055: Remove Adjacent Duplicates Using Stack
 *
 * Remove all adjacent duplicate characters from a string using Stack.
 *
 * Problem Statement:
 * Given a string, remove all adjacent duplicate characters.
 * Use a Stack data structure to efficiently handle this.
 *
 * Example:
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * - Process 'a': stack = [a]
 * - Process 'b': stack = [a,b]
 * - Process 'b': top is 'b', pop it, stack = [a]
 * - Process 'a': top is 'a', pop it, stack = []
 * - Process 'c': stack = [c]
 * - Process 'a': stack = [c,a]
 * Result: "ca"
 *
 * Algorithm:
 * - Use Stack to store characters
 * - For each character:
 *   - If stack is not empty and top equals current char, pop
 *   - Otherwise, push current char
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 */
public class InterviewQuestion055_RemoveAdjacentDuplicatesStack {
    public static void main(String[] args) {
        System.out.println("=== Remove Adjacent Duplicates (Stack) ===\n");

        // Test Case 1
        String s1 = "abbaca";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: \"" + removeDuplicates(s1) + "\"");
        System.out.println("Expected: \"ca\"\n");

        // Test Case 2
        String s2 = "aa";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: \"" + removeDuplicates(s2) + "\"");
        System.out.println("Expected: \"\"\n");

        // Test Case 3
        String s3 = "abc";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: \"" + removeDuplicates(s3) + "\"");
        System.out.println("Expected: \"abc\"\n");

        // Test Case 4
        String s4 = "aabbcc";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: \"" + removeDuplicates(s4) + "\"");
        System.out.println("Expected: \"\"\n");

        // Test Case 5
        String s5 = "baab";
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Output: \"" + removeDuplicates(s5) + "\"");
        System.out.println("Expected: \"\"\n");

        // Detailed Example
        System.out.println("=== Detailed Breakdown for \"abbaca\" ===");
        removeDuplicatesDetailed("abbaca");
    }

    static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    static void removeDuplicatesDetailed(String s) {
        Stack<Character> stack = new Stack<>();

        System.out.println("Processing characters:");
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                System.out.println("  Character '" + c + "': matches top, pop");
                stack.pop();
            } else {
                System.out.println("  Character '" + c + "': push to stack");
                stack.push(c);
            }
            System.out.println("    Stack: " + stackToString(stack));
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        String finalResult = result.reverse().toString();

        System.out.println("\nFinal Result: \"" + finalResult + "\"");
    }

    static String stackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
            if (i < stack.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
