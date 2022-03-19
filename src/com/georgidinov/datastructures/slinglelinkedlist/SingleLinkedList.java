package com.georgidinov.datastructures.slinglelinkedlist;

import com.georgidinov.datastructures.DataStructure;

public interface SingleLinkedList<T extends Comparable<T>> extends DataStructure<T> {

    void add(T value);

    T remove();

    T removeFromFront();

    boolean contains(T value);
}
