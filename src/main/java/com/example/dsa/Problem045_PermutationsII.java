package com.example.dsa;

/**
 * Problem 045: Permutations II
 *
 * Return all unique permutations for an array that may contain duplicates.
 *
 * Solution explanation in code comments.
 */
public class Problem045_PermutationsII {
    public static void main(String[] args) {
        System.out.println("Running Problem045_PermutationsII");
        System.out.println("Example is in method comments.");
    }

    // Core solution method using Java 25 modern collection patterns
static java.util.List<java.util.List<Integer>> permuteUnique(int[] nums) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        java.util.Arrays.sort(nums);
        backtrackPermuteUnique(result, new java.util.ArrayList<>(), nums, new boolean[nums.length]);
        return java.util.List.copyOf(result.stream().map(java.util.List::copyOf).toList());
    }
    private static void backtrackPermuteUnique(java.util.List<java.util.List<Integer>> result, java.util.List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new java.util.ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            current.add(nums[i]);
            backtrackPermuteUnique(result, current, nums, used);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
