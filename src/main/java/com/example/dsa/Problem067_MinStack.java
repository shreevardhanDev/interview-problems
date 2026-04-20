package com.example.dsa;

/**
 * Problem 067: Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Solution explanation in code comments.
 */
public class Problem067_MinStack {
    public static void main(String[] args) {
        System.out.println("Running Problem067_MinStack");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static class MinStack {
        private final java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
        private final java.util.Deque<Integer> minStack = new java.util.ArrayDeque<>();
        void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }
        void pop() {
            if (stack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }
        int top() {
            return stack.peek();
        }
        int getMin() {
            return minStack.peek();
        }
    }
}
