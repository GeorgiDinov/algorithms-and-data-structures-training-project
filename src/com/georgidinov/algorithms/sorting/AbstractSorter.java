package com.georgidinov.algorithms.sorting;

import com.georgidinov.util.MyUtil;
import com.georgidinov.util.ThreadColor;

import java.util.Arrays;

public abstract class AbstractSorter<T> implements Sorter<T> {


    private static final String ARRAY_NOT_INIT_MESSAGE = "The array is not initialized.";
    private static final String EMPTY_ARRAY_MESSAGE = "The array is empty.";

    protected static final String SINGLE_ELEMENT_ARRAY_MESSAGE = "The array has only one element.";


    protected void swap(T[] array, int leftIndex, int rightIndex) {
        if (isIndexOutOfBounds(array, leftIndex)) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds. Index={" + leftIndex + "}");
        }
        if (isIndexOutOfBounds(array, rightIndex)) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds. Index={" + rightIndex + "}");
        }
        if (leftIndex == rightIndex) {
            return;
        }
        if (array[leftIndex] == array[rightIndex]) {
            return;
        }
        T temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

    protected boolean isArrayNull(T[] array) {
        return array == null;
    }

    protected boolean isArrayEmpty(T[] array) {
        if (isArrayNull(array)) {
            throw new RuntimeException(ARRAY_NOT_INIT_MESSAGE);
        }
        return array.length == 0;
    }

    protected boolean isArrayWithOneElement(T[] array) {
        if (isArrayNull(array)) {
            throw new RuntimeException(ARRAY_NOT_INIT_MESSAGE);
        }
        return array.length == 1;
    }

    protected boolean isIndexOutOfBounds(T[] array, int index) {
        validateArrayEligibilityForSorting(array);
        if (index < 0) {
            return true;
        }
        return index > array.length - 1;
    }

    protected boolean isIndexInBounds(T[] array, int index) {
        validateArrayEligibilityForSorting(array);
        return index >= 0 && index <= array.length - 1;
    }

    protected void validateArrayEligibilityForSorting(T[] array) {
        if (isArrayNull(array)) {
            throw new RuntimeException(ARRAY_NOT_INIT_MESSAGE);
        }
        if (isArrayEmpty(array)) {
            throw new RuntimeException(EMPTY_ARRAY_MESSAGE);
        }
    }

    protected void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    protected void printArrayInColor(T[] array, ThreadColor threadColor) {
        MyUtil.printInColor(Arrays.toString(array), threadColor);
    }

}