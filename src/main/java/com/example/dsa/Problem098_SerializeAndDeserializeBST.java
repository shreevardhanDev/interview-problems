package com.example.dsa;

/**
 * Problem 098: Serialize and Deserialize BST
 *
 * Serialize and deserialize a binary search tree with efficient storage.
 *
 * Solution explanation in code comments.
 */
public class Problem098_SerializeAndDeserializeBST {
    public static void main(String[] args) {
        System.out.println("Running Problem098_SerializeAndDeserializeBST");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static String serializeBST(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeBSTNode(root, sb);
        return sb.toString();
    }
    private static void serializeBSTNode(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        if (sb.length() > 0) sb.append(',');
        sb.append(node.val);
        serializeBSTNode(node.left, sb);
        serializeBSTNode(node.right, sb);
    }
    static TreeNode deserializeBST(String data) {
        if (data.isEmpty()) return null;
        java.util.Queue<Integer> values = new java.util.LinkedList<>();
        for (String token : data.split(",")) values.offer(Integer.parseInt(token));
        return deserializeBSTNode(values, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static TreeNode deserializeBSTNode(java.util.Queue<Integer> values, int min, int max) {
        if (values.isEmpty()) return null;
        int value = values.peek();
        if (value < min || value > max) return null;
        values.poll();
        TreeNode node = new TreeNode(value);
        node.left = deserializeBSTNode(values, min, value);
        node.right = deserializeBSTNode(values, value, max);
        return node;
    }
}
