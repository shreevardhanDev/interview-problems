package com.example.dsa;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 107: Longest Consecutive Sequence
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Constraints:
 * - 0 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 *
 * Approach: Hash Set
 * - Use a set to store all numbers for O(1) lookup
 * - For each number, if it's the start of a sequence (no left neighbor), count the length
 * - Time: O(n), Space: O(n)
 */
public class Problem107_LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println("Running Problem107_LongestConsecutiveSequence");
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutive(nums);
        System.out.println(result); // Output: 4
    }

    /**
     * Find the length of the longest consecutive sequence.
     *
     * @param nums the array of integers
     * @return the length of the longest consecutive sequence
     */
    static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num : nums) {
            // Check if it's the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}