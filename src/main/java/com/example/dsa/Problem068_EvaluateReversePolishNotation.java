package com.example.dsa;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem 068: Evaluate Reverse Polish Notation
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Approach: Stack-based Evaluation
 * - For each token: if operator, pop two operands and push result
 * - If number, push to stack
 * - RPN eliminates need for parentheses and operator precedence
 * - Time: O(n), Space: O(n) for stack
 */
public class Problem068_EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println("Running Problem068_EvaluateReversePolishNotation");
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens)); // Output: 9
    }

    /**
     * Evaluate arithmetic expression in Reverse Polish Notation (RPN).
     * Example: "2 1 +" => 3, "2 1 + 3 *" => 9
     * 
     * @param tokens array of numbers and operators as strings
     * @return evaluated result
     */
static int evalRPN(String[] tokens) {
        // Stack to store intermediate results
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String token : tokens) {
            // Java 25 switch expression: map operators to results with yield
            int value = switch (token) {
                // For commutative operations, order doesn't matter
                case "+" -> stack.pop() + stack.pop();
                case "*" -> stack.pop() * stack.pop();
                
                // For non-commutative operations (- and /), order matters
                // First pop is second operand, second pop is first operand
                case "-" -> {
                    int b = stack.pop();  // Second operand
                    int a = stack.pop();  // First operand
                    yield a - b;
                }
                case "/" -> {
                    int b = stack.pop();  // Second operand
                    int a = stack.pop();  // First operand
                    yield a / b;  // Integer division
                }
                
                // Not an operator, must be a number
                default -> Integer.parseInt(token);
            };
            
            // Push result back onto stack
            stack.push(value);
        }
        
        // Final result is only element in stack
        return stack.pop();
    }
}
