package com.example.interview_questions;

import java.util.Arrays;

/**
 * Interview Question 048: Product of Array Except Self (LeetCode 238)
 *
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all elements of nums except nums[i].
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Explanation:
 * - answer[0] = 2*3*4 = 24
 * - answer[1] = 1*3*4 = 12
 * - answer[2] = 1*2*4 = 8
 * - answer[3] = 1*2*3 = 6
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Constraints:
 * - 2 <= nums.length <= 10^5
 * - -30 <= nums[i] <= 30
 * - Product of any prefix or suffix is guaranteed to fit in a 32-bit integer.
 *
 * Approach: Two-Pass Left and Right Prefix Products
 * - First pass: fill answer[i] with product of all elements to the left
 * - Second pass: multiply by product of all elements to the right
 * - Time: O(n), Space: O(1) [excluding output array]
 */
public class InterviewQuestion048_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion048_ProductOfArrayExceptSelf");
        
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelf(nums1);
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(result1)); // [24, 12, 8, 6]
        
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelf(nums2);
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(result2)); // [0, 0, 9, 0, 0]
    }

    /**
     * Calculate product of array except self without division.
     * Uses prefix and suffix products approach.
     *
     * @param nums the input array
     * @return array where answer[i] = product of all elements except nums[i]
     */
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // First pass: calculate prefix products (product of all elements to the left)
        // answer[i] will contain product of all elements before index i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Second pass: calculate suffix products (product of all elements to the right)
        // Multiply answer[i] with product of all elements after index i
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffixProduct;
            suffixProduct *= nums[i];
        }
        
        return answer;
    }
}
