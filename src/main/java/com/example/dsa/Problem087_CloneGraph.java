package com.example.dsa;

import java.util.Map;
import java.util.HashMap;

/**
 * Problem 087: Clone Graph
 *
 * Return a deep copy of a graph given a reference node.
 *
 * Solution explanation in code comments.
 */
public class Problem087_CloneGraph {
    public static void main(String[] args) {
        System.out.println("Running Problem087_CloneGraph");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
    static Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return cloneNode(node, map);
    }

    private static Node cloneNode(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);
        Node copy = new Node(node.val);
        map.put(node, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneNode(neighbor, map));
        }
        return copy;
    }
}
