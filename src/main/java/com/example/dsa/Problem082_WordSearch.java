package com.example.dsa;

/**
 * Problem 082: Word Search
 *
 * Check if a word exists in a board by sequentially adjacent letters.
 *
 * Solution explanation in code comments.
 */
public class Problem082_WordSearch {
    public static void main(String[] args) {
        System.out.println("Running Problem082_WordSearch");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (searchWord(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private static boolean searchWord(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = searchWord(board, word, i + 1, j, index + 1)
            || searchWord(board, word, i - 1, j, index + 1)
            || searchWord(board, word, i, j + 1, index + 1)
            || searchWord(board, word, i, j - 1, index + 1);
        board[i][j] = temp;
        return found;
    }
}
