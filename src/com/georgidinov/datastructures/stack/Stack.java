package com.georgidinov.datastructures.stack;

import com.georgidinov.util.iterator.DataStructure;

public interface Stack<T> extends DataStructure<T> {

    void push(T value);

    T pop();

    T peek();

    int size();

    boolean isEmpty();

}