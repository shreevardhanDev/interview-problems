package com.example.interview_questions;

import java.util.Stack;

/**
 * Interview Question 006: Remove All Adjacent Duplicates in String
 *
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we can no longer do so.
 *
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 *
 * Example 1:
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation: For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move. The result of this move is string "aaca", of which only "aa" is possible, so the final string is "ca".
 *
 * Example 2:
 * Input: s = "azxxzy"
 * Output: "ay"
 *
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s consists of lowercase English letters.
 *
 * Explanation: Use a stack to remove adjacent duplicates.
 * Time: O(n), Space: O(n)
 */
public class InterviewQuestion006_RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion006_RemoveAllAdjacentDuplicatesInString");
        String s = "aabbaaaacaaab";
        String result = removeDuplicates(s);
        System.out.println(result); // Output: ca
    }

    /**
     * Remove all adjacent duplicates in string.
     *
     * @param s the input string
     * @return the string after removals
     */
    static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}