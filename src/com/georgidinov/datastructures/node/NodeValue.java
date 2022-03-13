package com.georgidinov.datastructures.node;

public interface NodeValue<T extends Comparable<T>> {

    void setValue(T value);

    T getValue();

}