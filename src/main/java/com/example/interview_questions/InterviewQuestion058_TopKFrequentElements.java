package com.example.interview_questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Interview Question 058: Top K Frequent Elements (GroupAnagrams.java variant)
 *
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,1,2,2,2,2,3,3,4,4,4,4,4,5,5,6], k = 3
 * Output: [4,1,2]
 * Explanation: Elements 4, 1, and 2 appear 5, 4, and 4 times respectively.
 *
 * Example 2:
 * Input: nums = [33,33,44,44,44,11,22,11,11,11], k = 2
 * Output: [11,44]
 * Explanation: Elements 11 and 44 appear 4 and 3 times respectively.
 *
 * Approach: Grouping and Sorting
 * - Group elements by frequency using Collectors.groupingBy
 * - Sort by frequency in descending order
 * - Take first k elements
 * - Time: O(n log n), Space: O(n)
 */
public class InterviewQuestion058_TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion058_TopKFrequentElements");
        
        int[] nums1 = {1,1,1,1,2,2,2,2,3,3,4,4,4,4,4,5,5,6};
        int k1 = 3;
        List<Integer> result1 = topKFrequent(nums1, k1);
        System.out.println("Input: " + Arrays.toString(nums1) + ", k=" + k1);
        System.out.println("Output: " + result1); // [4,1,2]
        
        int[] nums2 = {33,33,44,44,44,11,22,11,11,11};
        int k2 = 2;
        List<Integer> result2 = topKFrequent(nums2, k2);
        System.out.println("\nInput: " + Arrays.toString(nums2) + ", k=" + k2);
        System.out.println("Output: " + result2); // [11,44]
        
        int[] nums3 = {1,2,2,3,3,3};
        int k3 = 2;
        List<Integer> result3 = topKFrequent(nums3, k3);
        System.out.println("\nInput: " + Arrays.toString(nums3) + ", k=" + k3);
        System.out.println("Output: " + result3); // [3,2]
    }

    /**
     * Find k most frequent elements using grouping and sorting.
     *
     * @param nums the input array
     * @param k number of most frequent elements to return
     * @return list of k most frequent elements
     */
    static List<Integer> topKFrequent(int[] nums, int k) {
        // Group by element and count frequency
        Map<Integer, Long> frequencyMap = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(
                num -> num,
                Collectors.counting()
            ));
        
        // Sort by frequency in descending order and take first k
        return frequencyMap.entrySet().stream()
            .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
            .limit(k)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}
