package com.example.dsa;

/**
 * Problem 072: Serialize and Deserialize Binary Tree
 *
 * Implement serialization and deserialization of a binary tree.
 *
 * Solution explanation in code comments.
 */
public class Problem072_SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        System.out.println("Running Problem072_SerializeAndDeserializeBinaryTree");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeNode(root, sb);
        return sb.toString();
    }
    private static void serializeNode(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(',');
        serializeNode(node.left, sb);
        serializeNode(node.right, sb);
    }
    static TreeNode deserialize(String data) {
        java.util.Deque<String> values = new java.util.ArrayDeque<>(java.util.Arrays.asList(data.split(",")));
        return deserializeNode(values);
    }
    private static TreeNode deserializeNode(java.util.Deque<String> values) {
        String val = values.poll();
        if (val == null || val.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeNode(values);
        node.right = deserializeNode(values);
        return node;
    }
}
