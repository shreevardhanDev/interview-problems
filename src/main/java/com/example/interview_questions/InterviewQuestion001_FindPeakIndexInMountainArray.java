package com.example.interview_questions;

/**
 * Interview Question 001: Find Peak Index in a Mountain Array
 *
 * An array arr is a mountain array if and only if:
 * - arr.length >= 3
 * - There exists some i with 0 < i < arr.length - 1 such that:
 *   - arr[0] < arr[1] < ... < arr[i-1] < arr[i]
 *   - arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 *
 * Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i-1] < arr[i] > arr[i+1] > ... > arr[arr.length - 1].
 *
 * You must solve it in O(log(arr.length)) time complexity.
 *
 * Example 1:
 * Input: arr = [0,1,0]
 * Output: 1
 *
 * Example 2:
 * Input: arr = [0,2,1,0]
 * Output: 1
 *
 * Example 3:
 * Input: arr = [0,10,5,2]
 * Output: 1
 *
 * Constraints:
 * - 3 <= arr.length <= 10^5
 * - 0 <= arr[i] <= 10^6
 * - arr is guaranteed to be a mountain array.
 *
 * Explanation: Use binary search to find the peak. The peak is where arr[mid] > arr[mid+1].
 * Time: O(log n), Space: O(1)
 */
public class InterviewQuestion001_FindPeakIndexInMountainArray {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion001_FindPeakIndexInMountainArray");
        int[] arr = {0, 1, 0};
        int result = peakIndexInMountainArray(arr);
        System.out.println(result); // Output: 1
    }

    /**
     * Find the peak index in a mountain array.
     *
     * @param arr the mountain array
     * @return the index of the peak
     */
    static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}