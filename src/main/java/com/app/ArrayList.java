package com.app;

import java.util.Optional;

public class ArrayList<T> implements MutableList<T> {


    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.50;

    private T[] array;
    private int capacity;
    private int size;

    public ArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }


    public void ensureCapacity(int newCapacity) {
        if (newCapacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }

        if (newCapacity < capacity) {
            return;
        }

        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < capacity; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
        capacity = newCapacity;
    }


    @Override
    public void add(T element) {
        if (size >= capacity * LOAD_FACTOR) {
            ensureCapacity(capacity * 2);
        }
        array[size] = element;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;

    }

    @Override
    public void set(int index, T element) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        array[index] = element;

    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Optional<T> get(int index) {
        if (index < 0 || index >= size) {
            return Optional.empty();
        }

        return Optional.of(array[index]);
    }

    @Override
    public int size() {
        return 0;
    }
}
