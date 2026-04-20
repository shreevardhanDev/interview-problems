package com.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 038: Combination Sum
 *
 * Return all unique combinations of candidates where the chosen numbers sum to target.
 *
 * Approach: Backtracking with Pruning
 * - Sort candidates for early termination when exceeding target
 * - Each candidate can be reused unlimited times
 * - Recursively explore by adding candidate and reducing target
 * - Time: O(N^(T/M)), Space: O(T/M) for recursion depth
 */
public class Problem038_CombinationSum {
    public static void main(String[] args) {
        System.out.println("Running Problem038_CombinationSum");
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> result = combinationSum(candidates, 7);
        System.out.println(result); // Output: [[2,2,3], [7]]
    }

    /**
     * Find all unique combinations that sum to target.
     * Each candidate can be used unlimited times.
     * 
     * @param candidates array of candidate integers
     * @param target the target sum
     * @return list of all unique combinations summing to target
     */
static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort for pruning: stop exploring when sum exceeds target
        Arrays.sort(candidates);
        backtrackCombinationSum(result, new ArrayList<>(), candidates, target, 0);
        return List.copyOf(result.stream().map(List::copyOf).toList());
    }
    
    /**
     * Backtracking helper to find combinations.
     * 
     * @param result list to collect valid combinations
     * @param current current combination being built
     * @param candidates sorted array of candidates
     * @param remaining sum still needed
     * @param start index to start searching from (avoid duplicates)
     */
    private static void backtrackCombinationSum(List<List<Integer>> result, List<Integer> current, int[] candidates, int remaining, int start) {
        // Base case: found valid combination
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Explore candidates from start onwards
        for (int i = start; i < candidates.length && candidates[i] <= remaining; i++) {
            // Pruning: if candidate exceeds remaining, all further won't work either
            current.add(candidates[i]);
            // Same index: candidate can be reused
            backtrackCombinationSum(result, current, candidates, remaining - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }
}
