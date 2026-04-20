package com.example.dsa;

/**
 * Problem 081: Subsets
 *
 * Return all possible subsets of a set of distinct integers.
 *
 * Solution explanation in code comments.
 */
public class Problem081_Subsets {
    public static void main(String[] args) {
        System.out.println("Running Problem081_Subsets");
        System.out.println("Example is in method comments.");
    }

    // Core solution method using Java 25 immutable collection patterns
static java.util.List<java.util.List<Integer>> subsets(int[] nums) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        backtrackSubsets(result, new java.util.ArrayList<>(), nums, 0);
        return java.util.List.copyOf(result.stream().map(java.util.List::copyOf).toList());
    }
    private static void backtrackSubsets(java.util.List<java.util.List<Integer>> result, java.util.List<Integer> current, int[] nums, int index) {
        result.add(new java.util.ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrackSubsets(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
