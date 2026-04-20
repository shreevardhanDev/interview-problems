package com.example.dsa;

/**
 * Problem 097: LRU Cache
 *
 * Design and implement an LRU cache with get and put operations in O(1).
 *
 * Solution explanation in code comments.
 */
public class Problem097_LRUCache {
    public static void main(String[] args) {
        System.out.println("Running Problem097_LRUCache");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static class LRUCache {
        private final int capacity;
        private final java.util.Map<Integer, NodeLRU> map;
        private final NodeLRU head;
        private final NodeLRU tail;
        static class NodeLRU {
            int key, value;
            NodeLRU prev, next;
            NodeLRU(int key, int value) { this.key = key; this.value = value; }
        }
        LRUCache(int capacity) {
            this.capacity = capacity;
            map = new java.util.HashMap<>();
            head = new NodeLRU(0, 0);
            tail = new NodeLRU(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        int get(int key) {
            NodeLRU node = map.get(key);
            if (node == null) return -1;
            remove(node);
            insert(node);
            return node.value;
        }
        void put(int key, int value) {
            if (map.containsKey(key)) {
                NodeLRU node = map.get(key);
                node.value = value;
                remove(node);
                insert(node);
            } else {
                if (map.size() == capacity) {
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                }
                NodeLRU node = new NodeLRU(key, value);
                map.put(key, node);
                insert(node);
            }
        }
        private void remove(NodeLRU node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        private void insert(NodeLRU node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
    }
}
