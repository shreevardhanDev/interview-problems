package com.example.interview_questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Interview Question 008: First Non-Repeating Element
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 *
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 *
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 *
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s consists of only lowercase English letters.
 *
 * Explanation: Use a map to count frequencies, then find first with count 1.
 * Time: O(n), Space: O(1) since 26 letters.
 */
public class InterviewQuestion008_FirstNonRepeatingElement {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion008_FirstNonRepeatingElement");
        String s = "leetcode";
        int result = firstUniqChar(s);
        System.out.println(result); // Output: 0
    }

    /**
     * Find the first non-repeating character index.
     *
     * @param s the string
     * @return the index or -1
     */
    static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}