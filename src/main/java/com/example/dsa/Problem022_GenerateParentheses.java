package com.example.dsa;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 022: Generate Parentheses
 *
 * Generate all combinations of well-formed parentheses given n pairs.
 *
 * Approach: Backtracking with Balance Tracking
 * - At each step: can add '(' if haven't used all opens
 * - Can add ')' if unused closes remain and opens > closes
 * - Stop when string length reaches 2n (all pairs placed)
 * - Time: O(4^n / sqrt(n)), Space: O(n) recursion depth
 */
public class Problem022_GenerateParentheses {
    public static void main(String[] args) {
        System.out.println("Running Problem022_GenerateParentheses");
        List<String> result = generateParenthesis(3);
        System.out.println(result); // Output: [((())), (()()), (())(), ()(()), ()()()]
    }

    /**
     * Generate all valid combinations of n pairs of parentheses.
     * 
     * @param n the number of parenthesis pairs
     * @return list of all valid combinations
     */
static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrackParenthesis(result, new StringBuilder(), 0, 0, n);
        return List.copyOf(result);
    }
    
    /**
     * Backtracking helper to generate valid parenthesis combinations.
     * 
     * @param result list to collect valid combinations
     * @param current current string being built
     * @param open count of '(' added so far
     * @param close count of ')' added so far
     * @param max total pairs needed
     */
    private static void backtrackParenthesis(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base case: complete string with max pairs
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }
        
        // Add opening parenthesis if not exceeded max
        if (open < max) {
            current.append('(');
            backtrackParenthesis(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        
        // Add closing parenthesis if available and needed (close < open)
        if (close < open) {
            current.append(')');
            backtrackParenthesis(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
