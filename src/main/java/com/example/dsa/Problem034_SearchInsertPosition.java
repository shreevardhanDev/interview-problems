package com.example.dsa;

/**
 * Problem 034: Search Insert Position
 *
 * Return the index where a target should be inserted in a sorted array.
 *
 * Approach: Binary Search Variant
 * - If target found, return its index
 * - If not found, left pointer will be at correct insertion position
 * - Time: O(log n), Space: O(1)
 */
public class Problem034_SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println("Running Problem034_SearchInsertPosition");
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));  // Output: 2
        System.out.println(searchInsert(nums, 7));  // Output: 4
        System.out.println(searchInsert(nums, 0));  // Output: 0
    }

    /**
     * Find index of target or position where it should be inserted.
     * 
     * @param nums the sorted array
     * @param target the value to search for
     * @return index of target or insertion position
     */
static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (nums[mid] == target) {
                return mid;  // Target found
            } else if (nums[mid] < target) {
                // Target must be in right half
                left = mid + 1;
            } else {
                // Target must be in left half
                right = mid - 1;
            }
        }
        
        // left is now the insertion position
        return left;
    }
}
