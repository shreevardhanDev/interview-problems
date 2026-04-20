package com.example.dsa;

/**
 * Problem 017: Letter Combinations of a Phone Number
 *
 * Return all possible letter combinations that the number could represent.
 *
 * Solution explanation in code comments.
 */
public class Problem017_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println("Running Problem017_LetterCombinationsOfAPhoneNumber");
        System.out.println("Example is in method comments.");
    }

    // Core solution method using Java 25 collection patterns
static java.util.List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return java.util.List.of();
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        java.util.List<String> result = new java.util.ArrayList<>();
        backtrackCombination(result, mapping, digits, 0, new StringBuilder());
        return java.util.List.copyOf(result);
    }
    private static void backtrackCombination(java.util.List<String> result, String[] mapping, String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrackCombination(result, mapping, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
