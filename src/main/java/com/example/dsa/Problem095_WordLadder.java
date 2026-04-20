package com.example.dsa;

/**
 * Problem 095: Word Ladder
 *
 * Return the length of the shortest transformation sequence from beginWord to endWord.
 *
 * Solution explanation in code comments.
 */
public class Problem095_WordLadder {
    public static void main(String[] args) {
        System.out.println("Running Problem095_WordLadder");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int ladderLength(String beginWord, String endWord, java.util.List<String> wordList) {
        java.util.Set<String> dict = new java.util.HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        java.util.Queue<String> queue = new java.util.ArrayDeque<>();
        queue.offer(beginWord);
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return steps;
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String next = new String(chars);
                        if (dict.contains(next)) {
                            dict.remove(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}
