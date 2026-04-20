package com.example.dsa;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem 020: Valid Parentheses
 *
 * Check if parentheses, brackets, and braces are properly closed and nested.
 *
 * Approach: Stack-based validation
 * - For each opening bracket, push its matching closing bracket onto stack
 * - For each closing bracket, verify it matches the top of stack
 * - At the end, stack must be empty for valid string
 * - Time: O(n), Space: O(n)
 */
public class Problem020_ValidParentheses {
    public static void main(String[] args) {
        System.out.println("Running Problem020_ValidParentheses");
        System.out.println(isValid("()"));       // true
        System.out.println(isValid("([{}])"));   // true
        System.out.println(isValid("([)]"));     // false
    }

    /**
     * Validate if parentheses, brackets, and braces are properly matched and nested.
     * 
     * @param s the string to validate
     * @return true if all parentheses are valid, false otherwise
     */
static boolean isValid(String s) {
        // Stack to track expected closing brackets
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            // Java 25 switch expression: map opening brackets to their closing pair
            Character matched = switch (c) {
                case '(' -> ')';
                case '{' -> '}';
                case '[' -> ']';
                default -> null;  // Not an opening bracket
            };
            
            if (matched != null) {
                // Opening bracket: push its expected closing bracket
                stack.push(matched);
            } else {
                // Closing bracket: must match stack top
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;  // Mismatch or nothing to close
                }
            }
        }
        
        // Valid only if all brackets were matched (stack is empty)
        return stack.isEmpty();
    }
}
