package com.example.interview_questions;

import java.util.Stack;

/**
 * Interview Question 004: Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 * - Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Constraints:
 * - 1 <= s.length <= 10^4
 * - s consists of parentheses only '()[]{}'.
 *
 * Explanation: Use a stack to match opening and closing brackets.
 * Time: O(n), Space: O(n)
 */
public class InterviewQuestion004_ValidParentheses {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion004_ValidParentheses");
        String s = "()[]{}";
        boolean result = isValid(s);
        System.out.println(result); // Output: true
    }

    /**
     * Check if the string has valid parentheses.
     *
     * @param s the input string
     * @return true if valid, false otherwise
     */
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}