package com.example.dsa;

/**
 * Problem 088: Maximum Product Subarray
 *
 * Find the contiguous subarray with the maximum product.
 *
 * Solution explanation in code comments.
 */
public class Problem088_MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println("Running Problem088_MaximumProductSubarray");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);
            result = Math.max(result, maxProd);
        }
        return result;
    }
}
