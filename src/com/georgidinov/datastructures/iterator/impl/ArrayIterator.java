package com.georgidinov.datastructures.iterator.impl;

import com.georgidinov.datastructures.iterator.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

    private int position;
    private T[] array;

    public ArrayIterator(T[] array) {
        this.position = 0;
        this.array = array;
    }


    @Override
    public boolean hasNext() {
        return position < array.length && array[position] != null;
    }

    @Override
    public T next() {
        return array[position++];
    }
}