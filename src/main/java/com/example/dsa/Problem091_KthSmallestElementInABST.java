package com.example.dsa;

/**
 * Problem 091: Kth Smallest Element in a BST
 *
 * Return the kth smallest value in a binary search tree.
 *
 * Solution explanation in code comments.
 */
public class Problem091_KthSmallestElementInABST {
    public static void main(String[] args) {
        System.out.println("Running Problem091_KthSmallestElementInABST");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int kthSmallest(TreeNode root, int k) {
        java.util.Deque<TreeNode> stack = new java.util.ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (--k == 0) return node.val;
            node = node.right;
        }
        return -1;
    }
}
