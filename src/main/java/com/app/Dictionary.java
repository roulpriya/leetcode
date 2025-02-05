package com.app;

import java.util.Optional;
import java.util.Set;

class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class Dictionary<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Node<K, V>[] table;
    private int capacity;
    private int size;

    public Dictionary() {
        table = new Node[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }

        if (newCapacity < capacity) {
            return;
        }

        Node<K, V>[] newTable = new Node[newCapacity];

        for (int i = 0; i < capacity; i++) {
            Node<K, V> node = table[i];
            while (node != null) {
                int newIndex = node.key.hashCode() % newCapacity;
                Node<K, V> nextNode = node.next;
                node.next = newTable[newIndex];
                newTable[newIndex] = node;
                node = nextNode;
            }
        }

        table = newTable;
        capacity = newCapacity;
    }

    public int size() {
        return size;
    }

    public record Entry<K, V>(K key, V value) {
    }

    public void set(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value cannot be null");
        }

        if(size() >= capacity * LOAD_FACTOR) {
            ensureCapacity(capacity * 2);
        }

        int hash = key.hashCode();
        int index = hash % capacity;

        Node<K, V> node = table[index];
        if (node == null) {
            table[index] = new Node<>(key, value);
            size++;
        } else if(node.key.equals(key)) {
            node.value = value;
        } else {
            while (node.next != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            node.next = new Node<>(key, value);
            size++;
        }

    }

    public Optional<V> get(K key) {
        int hash = key.hashCode();
        int index = hash % DEFAULT_CAPACITY;

        Node<K, V> node = table[index];

        while (node != null) {
            if (node.key.equals(key)) {
                return Optional.of(node.value);
            }
            node = node.next;
        }

        return Optional.empty();
    }

    public Set<Entry<K, V>> entries() {
        return Set.of();
    }

}
