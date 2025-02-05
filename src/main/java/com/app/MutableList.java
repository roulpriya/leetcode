package com.app;

public interface MutableList<T> extends List<T> {
    void add(T element);

    void remove(int index);

    void set(int index, T element);

    void clear();
}
