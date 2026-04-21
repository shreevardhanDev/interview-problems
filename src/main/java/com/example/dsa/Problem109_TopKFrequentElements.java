package com.example.dsa;

import java.util.*;

/**
 * Problem 109: Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 * - k is in the range [1, the number of unique elements in the array]
 * - It is guaranteed that the answer is unique.
 *
 * Approach: Bucket Sort / Heap
 * - Use a frequency map
 * - Use a max heap or bucket sort to get top k
 * - Time: O(n log k) with heap, Space: O(n)
 */
public class Problem109_TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println("Running Problem109_TopKFrequentElements");
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println(Arrays.toString(result)); // Output: [1,2] or [2,1]
    }

    /**
     * Find the k most frequent elements.
     *
     * @param nums the array of integers
     * @param k the number of top frequent elements
     * @return the top k frequent elements
     */
    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min heap for top k
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue)
        );

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }
}