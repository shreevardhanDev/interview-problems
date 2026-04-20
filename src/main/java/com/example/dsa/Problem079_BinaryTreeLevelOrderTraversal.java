package com.example.dsa;

/**
 * Problem 079: Binary Tree Level Order Traversal
 *
 * Return level order traversal of a binary tree.
 *
 * Solution explanation in code comments.
 */
public class Problem079_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        System.out.println("Running Problem079_BinaryTreeLevelOrderTraversal");
        System.out.println("Example is in method comments.");
    }

    // Core solution method using Java 25 modern collection patterns
static java.util.List<java.util.List<Integer>> levelOrder(TreeNode root) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) return result;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            java.util.List<Integer> level = new java.util.ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(java.util.List.copyOf(level));
        }
        return java.util.List.copyOf(result);
    }
}
