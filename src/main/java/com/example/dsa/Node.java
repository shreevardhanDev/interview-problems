package com.example.dsa;

public class Node {
    public int val;
    public java.util.List<Node> neighbors;
    public java.util.List<Node> children;

    public Node(int val) {
        this.val = val;
        this.neighbors = new java.util.ArrayList<>();
        this.children = new java.util.ArrayList<>();
    }
}
