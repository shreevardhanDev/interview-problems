package com.example.interview_questions;

import java.util.*;

/**
 * Interview Question 018: Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Explanation: Use bucket sort or heap.
 */
public class InterviewQuestion018_TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion018_TopKFrequentElements");
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println(Arrays.toString(result)); // Output: [1,2]
    }

    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue)
        );
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) heap.poll();
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll().getKey();
        }
        return res;
    }
}