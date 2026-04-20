package com.example.dsa;

/**
 * Problem 044: Permutations
 *
 * Return all possible permutations of an array of distinct integers.
 *
 * Solution explanation in code comments.
 */
public class Problem044_Permutations {
    public static void main(String[] args) {
        System.out.println("Running Problem044_Permutations");
        System.out.println("Example is in method comments.");
    }

    // Core solution method using Java 25 immutable collection patterns
static java.util.List<java.util.List<Integer>> permute(int[] nums) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        backtrackPermute(result, new java.util.ArrayList<>(), nums);
        return java.util.List.copyOf(result.stream().map(java.util.List::copyOf).toList());
    }
    private static void backtrackPermute(java.util.List<java.util.List<Integer>> result, java.util.List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            result.add(new java.util.ArrayList<>(current));
            return;
        }
        for (int num : nums) {
            if (current.contains(num)) continue;
            current.add(num);
            backtrackPermute(result, current, nums);
            current.remove(current.size() - 1);
        }
    }
}
