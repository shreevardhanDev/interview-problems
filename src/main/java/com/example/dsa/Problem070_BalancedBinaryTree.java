package com.example.dsa;

/**
 * Problem 070: Balanced Binary Tree
 *
 * Determine if a binary tree is height-balanced.
 *
 * Solution explanation in code comments.
 */
public class Problem070_BalancedBinaryTree {
    public static void main(String[] args) {
        System.out.println("Running Problem070_BalancedBinaryTree");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    private static int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        if (left == -1) return -1;
        int right = height(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
