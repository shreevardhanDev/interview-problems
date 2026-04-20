package com.example.dsa;

/**
 * Problem 003: Longest Substring Without Repeating Characters
 *
 * Find the length of the longest substring without repeating characters.
 *
 * Approach: Sliding Window with Array Tracking
 * - Use array to track last seen index of each character (ASCII range 0-127)
 * - Maintain sliding window with start and end pointers
 * - When duplicate found, move start pointer to skip previous occurrence
 * - Time: O(n), Space: O(1) [fixed size array of 128]
 */
public class Problem003_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("Running Problem003_LongestSubstringWithoutRepeatingCharacters");
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3 ("abc")
    }

    /**
     * Find length of longest substring without repeating characters using sliding window.
     * 
     * @param s the input string
     * @return length of the longest substring without repeating characters
     */
static int lengthOfLongestSubstring(String s) {
        // Array tracks last seen index of each character (ASCII 0-127)
        int[] lastIndex = new int[128];
        
        int start = 0;  // Left pointer of sliding window
        int maxLen = 0; // Maximum length found so far
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // If character was seen before, move start pointer to skip previous occurrence
            start = Math.max(start, lastIndex[currentChar]);
            
            // Update maximum length with current window size
            maxLen = Math.max(maxLen, i - start + 1);
            
            // Store next index (i+1) to indicate where we should move if we see this char again
            lastIndex[currentChar] = i + 1;
        }
        
        return maxLen;
    }
}
