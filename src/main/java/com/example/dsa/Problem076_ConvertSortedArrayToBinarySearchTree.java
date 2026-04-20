package com.example.dsa;

/**
 * Problem 076: Convert Sorted Array to Binary Search Tree
 *
 * Convert a sorted array into a height-balanced BST.
 *
 * Solution explanation in code comments.
 */
public class Problem076_ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        System.out.println("Running Problem076_ConvertSortedArrayToBinarySearchTree");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
    private static TreeNode buildBST(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, low, mid - 1);
        root.right = buildBST(nums, mid + 1, high);
        return root;
    }
}
