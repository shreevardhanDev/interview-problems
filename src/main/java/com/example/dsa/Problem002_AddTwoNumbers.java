package com.example.dsa;

/**
 * Problem 002: Add Two Numbers
 *
 * Add two numbers represented by linked lists in reverse order and return their sum as a list.
 *
 * Approach: Single Pass with Carry Tracking
 * - Traverse both lists simultaneously
 * - Track carry from previous addition
 * - Build new list with sum digits
 * - Time: O(max(m, n)), Space: O(max(m, n))
 */
public class Problem002_AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println("Running Problem002_AddTwoNumbers");
        
        // Example: 342 + 465 = 807 (lists store in reverse: 2->4->3, 5->6->4)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        
        ListNode sum = addTwoNumbers(l1, l2);
        System.out.print("Result: ");
        while (sum != null) {
            System.out.print(sum.val);
            sum = sum.next;
        }
        System.out.println(); // Output: 708
    }

    /**
     * Add two numbers represented as linked lists (digits in reverse order).
     * 
     * @param l1 first number as linked list
     * @param l2 second number as linked list
     * @return sum as new linked list
     */
static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node simplifies result construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        // Continue while there are nodes in either list or remaining carry
        while (l1 != null || l2 != null || carry != 0) {
            // Get values, defaulting to 0 if list is exhausted
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            // Calculate sum and carry
            int sum = x + y + carry;
            carry = sum / 10;      // Carry for next iteration
            
            // Create new node with digit (single digit of sum)
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            // Advance pointers if nodes exist
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        
        // Skip dummy node and return actual result
        return dummy.next;
    }
}
