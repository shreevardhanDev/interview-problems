package com.example.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 029: Substring with Concatenation of All Words
 *
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once.
 *
 * Approach: Sliding Window with Word Frequency Matching
 * - Create frequency map of all words
 * - Slide window of size (word_len * num_words)
 * - Check if words in window match the frequency map
 * - Time: O(n * m * k) where n=string length, m=num words, k=word length
 * - Space: O(m * k) for maps
 */
public class Problem029_SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        System.out.println("Running Problem029_SubstringWithConcatenationOfAllWords");
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words)); // [0, 9]
    }

    /**
     * Find all indices where concatenation of all words appears.
     * 
     * @param s the source string
     * @param words array of words to concatenate
     * @return list of starting indices
     */
static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        if (words.length == 0 || s.isEmpty()) return result;
        
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;  // Total length of all words concatenated
        
        // Frequency map of all words to find
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) count.merge(word, 1, Integer::sum);  // Count occurrences
        
        // Check each possible starting position
        for (int i = 0; i + totalLen <= s.length(); i++) {
            // Frequency map of words in current window
            Map<String, Integer> seen = new HashMap<>();
            
            int j = 0;
            // Extract and verify each word in the window
            while (j < words.length) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                
                // Word not in target list
                if (!count.containsKey(word)) break;
                
                // Count this word occurrence
                seen.merge(word, 1, Integer::sum);
                
                // More occurrences than allowed
                if (seen.get(word) > count.get(word)) break;
                
                j++;
            }
            
            // All words matched perfectly
            if (j == words.length) result.add(i);
        }
        return result;
    }
}
