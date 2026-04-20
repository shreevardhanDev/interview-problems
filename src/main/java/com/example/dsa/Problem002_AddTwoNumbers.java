package com.example.dsa;

/**
 * Problem 002: Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807. Since the digits are stored in reverse order, 2->4->3 represents 342, and 5->6->4 represents 465.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 * - The number of nodes in each linked list is in the range [1, 100].
 * - 0 <= Node.val <= 9
 * - It is guaranteed that the list represents a number that does not have leading zeros.
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
