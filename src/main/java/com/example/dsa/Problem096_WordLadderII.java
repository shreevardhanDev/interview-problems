package com.example.dsa;

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
static java.util.List<java.util.List<String>> findLadders(String beginWord, String endWord, java.util.List<String> wordList) {
        java.util.Set<String> dict = new java.util.HashSet<>(wordList);
        java.util.List<java.util.List<String>> results = new java.util.ArrayList<>();
        if (!dict.contains(endWord)) return results;
        java.util.Map<String, java.util.List<String>> tree = new java.util.HashMap<>();
        java.util.Set<String> current = new java.util.HashSet<>();
        current.add(beginWord);
        dict.remove(beginWord);
        boolean found = false;
        while (!current.isEmpty() && !found) {
            java.util.Set<String> nextLevel = new java.util.HashSet<>();
            for (String word : current) {
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[i] == c) continue;
                        chars[i] = c;
                        String next = new String(chars);
                        if (dict.contains(next)) {
                            nextLevel.add(next);
                            tree.computeIfAbsent(word, _ -> new java.util.ArrayList<>()).add(next);
                        }
                    }
                }
            }
            dict.removeAll(nextLevel);
            if (nextLevel.contains(endWord)) found = true;
            current = nextLevel;
        }
        if (found) {
            backtrackLadders(results, new java.util.ArrayList<>(java.util.List.of(beginWord)), beginWord, endWord, tree);
        }
        return results;
    }
    private static void backtrackLadders(java.util.List<java.util.List<String>> results, java.util.List<String> path, String word, String endWord, java.util.Map<String, java.util.List<String>> tree) {
        if (word.equals(endWord)) {
            results.add(new java.util.ArrayList<>(path));
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
