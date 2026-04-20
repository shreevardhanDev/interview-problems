package com.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 047: Group Anagrams
 *
 * Group a list of strings into anagrams.
 *
 * Approach: Sorted Characters as Key
 * - Sort characters in each word to create a canonical form
 * - Use this sorted form as map key to group anagrams
 * - Words with same characters will have identical keys
 * - Time: O(n * k log k) where n=words, k=avg word length
 * - Space: O(n * k) for map storage
 */
public class Problem047_GroupAnagrams {
    public static void main(String[] args) {
        System.out.println("Running Problem047_GroupAnagrams");
        String[] input = {"eat", "tea", "ate", "tan", "ant"};
        System.out.println(groupAnagrams(input)); // [[eat,tea,ate], [tan,ant]]
    }

    /**
     * Group strings that are anagrams of each other.
     * 
     * @param strs array of strings to group
     * @return list of lists, each inner list contains anagrams
     */
static List<List<String>> groupAnagrams(String[] strs) {
        // Map: sorted chars -> list of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Sort characters to get canonical form (anagrams have identical sorted form)
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // computeIfAbsent: add word to existing list or create new one
            map.computeIfAbsent(key, _ -> new ArrayList<>()).add(s);
        }
        
        // Return immutable copy of values collection
        return List.copyOf(map.values());
    }
}
