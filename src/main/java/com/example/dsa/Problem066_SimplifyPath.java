package com.example.dsa;

/**
 * Problem 066: Simplify Path
 *
 * Simplify a Unix-style file path.
 *
 * Solution explanation in code comments.
 */
public class Problem066_SimplifyPath {
    public static void main(String[] args) {
        System.out.println("Running Problem066_SimplifyPath");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static String simplifyPath(String path) {
        java.util.Deque<String> stack = new java.util.ArrayDeque<>();
        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals(".")) continue;
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(part);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop()).insert(0, "/");
        }
        return result.toString();
    }
}
