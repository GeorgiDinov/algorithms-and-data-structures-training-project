package com.georgidinov.datastructures.doublelinkedlist;

import com.georgidinov.datastructures.DataStructure;

public interface DoubleLinkedList<T extends Comparable<T>> extends DataStructure<T> {


    void add(T value);

    T remove();

    void addFirst(T value);

    T removeFirst();

    void addLast(T value);

    T removeLast();

    T peekFirst();

    T peekLast();

    boolean contains(T value);

}