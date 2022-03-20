package com.georgidinov.datastructures.queue;

import com.georgidinov.datastructures.DataStructure;

public interface Queue<T extends Comparable<T>> extends DataStructure<T> {

    void add(T value);

    T remove();

    T peek();

}