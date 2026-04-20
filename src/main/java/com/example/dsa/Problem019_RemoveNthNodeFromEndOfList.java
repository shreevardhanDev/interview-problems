package com.example.dsa;

/**
 * Problem 019: Remove Nth Node From End of List
 *
 * Remove the nth node from the end of a singly linked list and return the head.
 *
 * Solution explanation in code comments.
 */
public class Problem019_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        System.out.println("Running Problem019_RemoveNthNodeFromEndOfList");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
