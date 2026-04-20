package com.example.dsa;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Problem 096: Word Ladder II
 *
 * Return all shortest transformation sequences from beginWord to endWord.
 *
 * Solution explanation in code comments.
 */
public class Problem096_WordLadderII {
    public static void main(String[] args) {
        System.out.println("Running Problem096_WordLadderII");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
    static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> results = new ArrayList<>();
        if (!dict.contains(endWord)) return results;
        Map<String, List<String>> tree = new HashMap<>();
        Set<String> current = new HashSet<>();
        current.add(beginWord);
        dict.remove(beginWord);
        boolean found = false;
        while (!current.isEmpty() && !found) {
            Set<String> nextLevel = new HashSet<>();
            for (String word : current) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[i] == c) continue;
                        chars[i] = c;
                        String next = new String(chars);
                        if (dict.contains(next)) {
                            nextLevel.add(next);
                            tree.computeIfAbsent(word, _ -> new ArrayList<>()).add(next);
                        }
                    }
                }
            }
            dict.removeAll(nextLevel);
            if (nextLevel.contains(endWord)) found = true;
            current = nextLevel;
        }
        if (found) {
            backtrackLadders(results, new ArrayList<>(List.of(beginWord)), beginWord, endWord, tree);
        }
        return results;
    }

    private static void backtrackLadders(List<List<String>> results, List<String> path, String word, String endWord, Map<String, List<String>> tree) {
        if (word.equals(endWord)) {
            results.add(new ArrayList<>(path));
            return;
        }
        if (!tree.containsKey(word)) return;
        for (String next : tree.get(word)) {
            path.add(next);
            backtrackLadders(results, path, next, endWord, tree);
            path.remove(path.size() - 1);
        }
    }
}
