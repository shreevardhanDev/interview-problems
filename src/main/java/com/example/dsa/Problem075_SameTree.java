package com.example.dsa;

/**
 * Problem 075: Same Tree
 *
 * Determine if two binary trees are structurally identical with same node values.
 *
 * Approach: Recursive Comparison
 * - Base case: if both null, trees are same; if one null, different
 * - Recursive case: check root value, then recursively check both subtrees
 * - Time: O(min(m, n)), Space: O(h) for recursion stack
 */
public class Problem075_SameTree {
    public static void main(String[] args) {
        System.out.println("Running Problem075_SameTree");
        
        // Create two identical trees
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        
        System.out.println(isSameTree(p, q)); // Output: true
    }

    /**
     * Check if two trees are identical (same structure and values).
     * 
     * @param p first binary tree
     * @param q second binary tree
     * @return true if trees are identical, false otherwise
     */
static boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: both null or one null (different)
        if (p == null || q == null) return p == q;
        
        // Recursive case: check value and both subtrees
        return p.val == q.val && 
               isSameTree(p.left, q.left) && 
               isSameTree(p.right, q.right);
    }
}
