package com.example.dsa;

/**
 * Problem 024: Reverse Nodes in k-Group
 *
 * Reverse nodes of a linked list k at a time and return the modified list.
 *
 * Solution explanation in code comments.
 */
public class Problem024_ReverseNodesInKGroup {
    public static void main(String[] args) {
        System.out.println("Running Problem024_ReverseNodesInKGroup");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;
        while (true) {
            ListNode kth = groupPrev;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) return dummy.next;
            }
            ListNode groupNext = kth.next;
            ListNode prev = groupPrev.next;
            ListNode curr = prev.next;
            for (int i = 1; i < k; i++) {
                prev.next = curr.next;
                curr.next = groupPrev.next;
                groupPrev.next = curr;
                curr = prev.next;
            }
            groupPrev = prev;
        }
    }
}
