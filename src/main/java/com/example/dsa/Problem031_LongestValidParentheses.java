package com.example.dsa;

/**
 * Problem 031: Longest Valid Parentheses
 *
 * Find the length of the longest valid parentheses substring.
 *
 * Solution explanation in code comments.
 */
public class Problem031_LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println("Running Problem031_LongestValidParentheses");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int longestValidParentheses(String s) {
        int maxLen = 0;
        java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else maxLen = Math.max(maxLen, i - stack.peek());
            }
        }
        return maxLen;
    }
}
