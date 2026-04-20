package com.example.dsa;

public class Helpers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    static class Node {
        public int val;
        public java.util.List<Node> neighbors;
        public Node(int val) {
            this.val = val;
            this.neighbors = new java.util.ArrayList<>();
        }
    }
}
