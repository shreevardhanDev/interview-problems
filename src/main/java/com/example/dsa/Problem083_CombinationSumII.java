package com.example.dsa;

/**
 * Problem 083: Combination Sum II
 *
 * Return unique combinations where candidates sum to target, each candidate may be used once.
 *
 * Solution explanation in code comments.
 */
public class Problem083_CombinationSumII {
    public static void main(String[] args) {
        System.out.println("Running Problem083_CombinationSumII");
        System.out.println("Example is in method comments.");
    }

    // Core solution method using Java 25 modern collection patterns
static java.util.List<java.util.List<Integer>> combinationSum2(int[] candidates, int target) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        java.util.Arrays.sort(candidates);
        backtrackCombinationSum2(result, new java.util.ArrayList<>(), candidates, target, 0);
        return java.util.List.copyOf(result.stream().map(java.util.List::copyOf).toList());
    }
    private static void backtrackCombinationSum2(java.util.List<java.util.List<Integer>> result, java.util.List<Integer> current, int[] candidates, int remaining, int start) {
        if (remaining == 0) {
            result.add(new java.util.ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length && candidates[i] <= remaining; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            current.add(candidates[i]);
            backtrackCombinationSum2(result, current, candidates, remaining - candidates[i], i + 1);
            current.remove(current.size() - 1);
        }
    }
}
