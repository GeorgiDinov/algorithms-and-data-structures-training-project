package com.georgidinov.util.iterator;

public class ArrayIterator<T> implements Iterator<T> {

    int position;
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