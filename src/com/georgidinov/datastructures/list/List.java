package com.georgidinov.datastructures.list;

import com.georgidinov.datastructures.DataStructure;

public interface List<T extends Comparable<T>> extends DataStructure<T> {

    void add(T value);

    void addFirst(T value);

    void addLast(T value);

    void addInOrder(T value);

    T remove();

    T removeFirst();

    T removeLast();

    T peekFirst();

    T peekLast();

}