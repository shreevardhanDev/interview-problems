package com.example.dsa;

/**
 * Problem 004: Median of Two Sorted Arrays
 *
 * Find the median of two sorted arrays in O(log(min(m, n))) time.
 *
 * Solution explanation in code comments.
 */
public class Problem004_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println("Running Problem004_MedianOfTwoSortedArrays");
        System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
    }

    // Core solution method
static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;
        while (low <= high) {
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;
            int leftMax1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int rightMin1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int leftMax2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int rightMin2 = (j == n) ? Integer.MAX_VALUE : nums2[j];
            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                if ((m + n) % 2 == 1) {
                    return Math.max(leftMax1, leftMax2);
                }
                return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
            } else if (leftMax1 > rightMin2) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not valid");
    }
}
