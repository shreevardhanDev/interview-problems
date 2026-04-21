package com.example.interview_questions;

import java.util.*;

/**
 * Interview Question 002: Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * - 1 <= strs.length <= 10^4
 * - 0 <= strs[i].length <= 100
 * - strs[i] consists of lowercase English letters.
 *
 * Explanation: Sort each string to use as key in a map, group the strings.
 * Time: O(n * k log k) where n is number of strings, k is max length.
 * Space: O(n * k)
 */
public class InterviewQuestion002_GroupAnagrams {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion002_GroupAnagrams");
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result); // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    }

    /**
     * Group anagrams together.
     *
     * @param strs the array of strings
     * @return list of grouped anagrams
     */
    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}