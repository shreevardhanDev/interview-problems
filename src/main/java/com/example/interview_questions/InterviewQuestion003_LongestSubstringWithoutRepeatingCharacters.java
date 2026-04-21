package com.example.interview_questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Interview Question 003: Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces.
 *
 * Explanation: Use sliding window with a set to track unique characters.
 * Time: O(n), Space: O(min(n, 128)) since ASCII.
 */
public class InterviewQuestion003_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion003_LongestSubstringWithoutRepeatingCharacters");
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result); // Output: 3
    }

    /**
     * Find the length of the longest substring without repeating characters.
     *
     * @param s the input string
     * @return the length
     */
    static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}