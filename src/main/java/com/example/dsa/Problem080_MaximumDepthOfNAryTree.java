package com.example.dsa;

/**
 * Problem 080: Maximum Depth of N-ary Tree
 *
 * Return the maximum depth of an N-ary tree.
 *
 * Solution explanation in code comments.
 */
public class Problem080_MaximumDepthOfNAryTree {
    public static void main(String[] args) {
        System.out.println("Running Problem080_MaximumDepthOfNAryTree");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int maxDepthNary(Node root) {
        if (root == null) return 0;
        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepthNary(child));
        }
        return depth + 1;
    }
}
