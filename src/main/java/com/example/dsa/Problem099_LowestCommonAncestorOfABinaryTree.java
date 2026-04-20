package com.example.dsa;

/**
 * Problem 099: Lowest Common Ancestor of a Binary Tree
 *
 * Find the lowest common ancestor of two nodes in a binary tree.
 *
 * Solution explanation in code comments.
 */
public class Problem099_LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        System.out.println("Running Problem099_LowestCommonAncestorOfABinaryTree");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
