package com.app.oracle;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    public class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {

        /**
         * Time Complexity: Both get and put we need as a constant time
         * DSA Combination: fast key-value access, last used
         * HashMap and Doubly LinkedList
         */

        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Create dummy head and tail nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node removeFromTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    public int get(int key) {
        Node node = cache.get(key);

        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if(node == null) {
            // Create new node with provided key and value
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);

            if(cache.size() > capacity) {
                Node tailNode = removeFromTail();
                cache.remove(tailNode.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
