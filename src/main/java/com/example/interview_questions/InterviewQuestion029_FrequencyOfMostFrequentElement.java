package com.example.interview_questions;

import java.util.Arrays;

/**
 * Interview Question 029: Frequency of the Most Frequent Element (LeetCode 1838)
 *
 * The frequency of an element is the number of times it occurs in an array.
 *
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
 *
 * Return the maximum possible frequency of an element after performing at most k operations.
 *
 * Example:
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 *
 * Explanation: Sort and use sliding window.
 */
public class InterviewQuestion029_FrequencyOfMostFrequentElement {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion029_FrequencyOfMostFrequentElement");
        int[] nums = {1, 2, 4};
        int k = 5;
        int result = maxFrequency(nums, k);
        System.out.println(result); // Output: 3
    }

    static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, maxFreq = 0;
        long total = 0;
        for (int right = 0; right < nums.length; right++) {
            total += nums[right];
            while ((long) nums[right] * (right - left + 1) - total > k) {
                total -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        return maxFreq;
    }
}