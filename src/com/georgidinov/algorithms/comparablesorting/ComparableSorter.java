package com.georgidinov.algorithms.comparablesorting;

@FunctionalInterface
public interface ComparableSorter<T extends Comparable<T>> {

    void sort(T[] array);

    //void sort(DataStructure<T> structure);

}