package com.example.dsa;

/**
 * Problem 021: Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a sorted list.
 *
 * Solution explanation in code comments.
 */
public class Problem021_MergeTwoSortedLists {
    public static void main(String[] args) {
        System.out.println("Running Problem021_MergeTwoSortedLists");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
