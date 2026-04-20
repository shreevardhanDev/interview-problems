package com.example.dsa;

/**
 * Problem 074: Maximum Depth of Binary Tree
 *
 * Return the maximum depth of a binary tree.
 *
 * Solution explanation in code comments.
 */
public class Problem074_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        System.out.println("Running Problem074_MaximumDepthOfBinaryTree");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
