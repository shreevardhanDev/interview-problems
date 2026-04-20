package com.example.dsa;

/**
 * Problem 077: Convert Sorted List to Binary Search Tree
 *
 * Convert a sorted linked list into a height-balanced BST.
 *
 * Solution explanation in code comments.
 */
public class Problem077_ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        System.out.println("Running Problem077_ConvertSortedListToBinarySearchTree");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
