package com.georgidinov.datastructures.stack;

import com.georgidinov.datastructures.DataStructure;

public interface Stack<T extends Comparable<T>> extends DataStructure<T> {

    void push(T value);

    T pop();

    T peek();

}