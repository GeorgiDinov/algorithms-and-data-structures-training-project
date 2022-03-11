package com.georgidinov.algorithms.sorting;

@FunctionalInterface
public interface Sorter<T> {

    void sort(T[] array);

}