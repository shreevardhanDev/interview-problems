package com.example.dsa;

import java.util.List;
import java.util.ArrayList;

public class Node {
    public int val;
    public List<Node> neighbors;
    public List<Node> children;

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
        this.children = new ArrayList<>();
    }
}
