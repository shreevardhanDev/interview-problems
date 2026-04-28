package com.example.interview_questions;

import java.util.Stack;

/**
 * Interview Question 056: Valid Parentheses with Brackets
 *
 * Validate if a string with parentheses, brackets, and braces is correctly matched.
 *
 * Problem Statement:
 * Given a string containing only parentheses '()', brackets '[]', and braces '{}',
 * determine if the input string is valid. A string is valid if:
 * 1. Every opening bracket has a closing bracket of the same type
 * 2. Brackets are closed in the correct order
 * 3. No extra closing brackets without matching opening bracket
 *
 * Example:
 * Input: "([)]"
 * Output: false
 * Explanation: Brackets are interleaved incorrectly
 *
 * Input: "([])"
 * Output: true
 * Explanation: All brackets are properly matched and nested
 *
 * Algorithm:
 * - Use Stack to track opening brackets
 * - For each character:
 *   - If opening bracket, push to stack
 *   - If closing bracket, check if it matches the top of stack
 * - At the end, stack should be empty
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 */
public class InterviewQuestion056_ValidParenthesesWithBrackets {
    public static void main(String[] args) {
        System.out.println("=== Valid Parentheses with Brackets ===\n");

        // Test Case 1
        String s1 = "()";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + isValid(s1));
        System.out.println("Expected: true\n");

        // Test Case 2
        String s2 = "([)]";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + isValid(s2));
        System.out.println("Expected: false\n");

        // Test Case 3
        String s3 = "()[]{}";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + isValid(s3));
        System.out.println("Expected: true\n");

        // Test Case 4
        String s4 = "{[]}";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: " + isValid(s4));
        System.out.println("Expected: true\n");

        // Test Case 5
        String s5 = "(([]){})";
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Output: " + isValid(s5));
        System.out.println("Expected: true\n");

        // Test Case 6
        String s6 = "]";
        System.out.println("Input: \"" + s6 + "\"");
        System.out.println("Output: " + isValid(s6));
        System.out.println("Expected: false\n");

        // Detailed Example
        System.out.println("=== Detailed Breakdown for \"([])\" ===");
        isValidDetailed("([])");
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatching(top, c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    static void isValidDetailed(String s) {
        Stack<Character> stack = new Stack<>();

        System.out.println("Processing string: \"" + s + "\"");
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                System.out.println("  '" + c + "' is opening, push");
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("  '" + c + "' is closing but stack empty - INVALID");
                    return;
                }
                char top = stack.pop();
                if (isMatching(top, c)) {
                    System.out.println("  '" + c + "' matches '" + top + "', pop");
                } else {
                    System.out.println("  '" + c + "' does NOT match '" + top + "' - INVALID");
                    return;
                }
            }
            System.out.println("    Stack: " + stackToString(stack));
        }

        if (stack.isEmpty()) {
            System.out.println("\nFinal: Stack is empty - VALID");
        } else {
            System.out.println("\nFinal: Stack is not empty - INVALID");
        }
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
