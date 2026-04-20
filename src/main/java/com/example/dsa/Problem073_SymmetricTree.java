package com.example.dsa;

/**
 * Problem 073: Symmetric Tree
 *
 * Check whether a binary tree is a mirror of itself.
 *
 * Solution explanation in code comments.
 */
public class Problem073_SymmetricTree {
    public static void main(String[] args) {
        System.out.println("Running Problem073_SymmetricTree");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }
    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
