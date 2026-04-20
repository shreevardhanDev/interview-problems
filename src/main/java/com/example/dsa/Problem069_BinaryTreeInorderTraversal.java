package com.example.dsa;

import java.util.List;
import java.util.ArrayList;

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
static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    private static void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
