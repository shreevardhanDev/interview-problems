package com.example.dsa;

import java.util.Arrays;

/**
 * Problem 108: Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Constraints:
 * - 2 <= nums.length <= 10^5
 * - -30 <= nums[i] <= 30
 * - The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * Approach: Prefix and Suffix Products
 * - Compute prefix products and suffix products
 * - For each index, multiply prefix[i-1] * suffix[i+1]
 * - Time: O(n), Space: O(n) (can be optimized to O(1) extra space)
 */
public class Problem108_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println("Running Problem108_ProductOfArrayExceptSelf");
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result)); // Output: [24,12,8,6]
    }

    /**
     * Compute the product of all elements except self.
     *
     * @param nums the input array
     * @return the array of products
     */
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] answer = new int[n];

        // Left products
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // Right products
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Answer
        for (int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
}