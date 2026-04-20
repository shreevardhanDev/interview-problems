package com.example.dsa;

/**
 * Problem 071: Lowest Common Ancestor of a Binary Search Tree
 *
 * Find the lowest common ancestor of two nodes in a BST.
 *
 * Solution explanation in code comments.
 */
public class Problem071_LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        System.out.println("Running Problem071_LowestCommonAncestorOfABinarySearchTree");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
