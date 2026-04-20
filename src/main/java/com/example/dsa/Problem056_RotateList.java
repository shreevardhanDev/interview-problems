package com.example.dsa;

/**
 * Problem 056: Rotate List
 *
 * Rotate a linked list to the right by k places.
 *
 * Solution explanation in code comments.
 */
public class Problem056_RotateList {
    public static void main(String[] args) {
        System.out.println("Running Problem056_RotateList");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k %= length;
        if (k == 0) return head;
        tail.next = head;
        int stepsToNewHead = length - k;
        ListNode newTail = tail;
        while (stepsToNewHead-- > 0) newTail = newTail.next;
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
