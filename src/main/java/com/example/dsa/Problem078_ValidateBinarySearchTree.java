package com.example.dsa;

/**
 * Problem 078: Validate Binary Search Tree
 *
 * Check whether a binary tree is a valid BST.
 *
 * Solution explanation in code comments.
 */
public class Problem078_ValidateBinarySearchTree {
    public static void main(String[] args) {
        System.out.println("Running Problem078_ValidateBinarySearchTree");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }
    private static boolean validateBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
        return validateBST(node.left, min, node.val) && validateBST(node.right, node.val, max);
    }
}
