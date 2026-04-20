package com.example.dsa;

/**
 * Problem 069: Binary Tree Inorder Traversal
 *
 * Return the inorder traversal of a binary tree.
 *
 * Solution explanation in code comments.
 */
public class Problem069_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        System.out.println("Running Problem069_BinaryTreeInorderTraversal");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static java.util.List<Integer> inorderTraversal(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        inorder(root, result);
        return result;
    }
    private static void inorder(TreeNode node, java.util.List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
