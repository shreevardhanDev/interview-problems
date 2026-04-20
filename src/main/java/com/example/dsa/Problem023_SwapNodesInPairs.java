package com.example.dsa;

/**
 * Problem 023: Swap Nodes in Pairs
 *
 * Swap every two adjacent nodes in a linked list without changing node values.
 *
 * Solution explanation in code comments.
 */
public class Problem023_SwapNodesInPairs {
    public static void main(String[] args) {
        System.out.println("Running Problem023_SwapNodesInPairs");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            second.next = first;
            current.next = second;
            current = first;
        }
        return dummy.next;
    }
}
