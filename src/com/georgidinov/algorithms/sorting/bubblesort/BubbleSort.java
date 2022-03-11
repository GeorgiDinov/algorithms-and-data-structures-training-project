package com.georgidinov.algorithms.sorting.bubblesort;

import com.georgidinov.algorithms.sorting.AbstractSorter;
import com.georgidinov.util.ThreadColor;

import java.util.stream.IntStream;

public class BubbleSort extends AbstractSorter<Integer> {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 8, 2, 15, 11, 7};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.printArrayInColor(array, ThreadColor.ANSI_RED);
        bubbleSort.sort(array);
        bubbleSort.printArrayInColor(array, ThreadColor.ANSI_GREEN);
    }


    @Override
    public void sort(Integer[] array) {
        validateArrayEligibilityForSorting(array);
        if (isArrayWithOneElement(array)) {
            System.out.println(SINGLE_ELEMENT_ARRAY_MESSAGE);
            return;
        }
        bubbleSortFlagImpl(array);
    }


    //== different implementations of the algorithm ==
    private void bubbleSortImpl(Integer[] array) {
        for (int last = array.length - 1; last > 0; last--) {
            for (int current = 0; current < last; current++) {
                int next = current + 1;
                if (array[current] > array[next]) {
                    swap(array, current, next);
                }
            }
        }
    }

    private void bubbleSortStreamImpl(Integer[] array) {
        int first = 0;
        int last = array.length - 1;
        IntStream.range(first, last)
                .flatMap(index -> IntStream.range(first, last - index))
                .forEach(current -> {
                    int next = current + 1;
                    if (array[current] > array[next]) {
                        swap(array, current, next);
                    }
                });
    }

    //optimized
    private void bubbleSortFlagImpl(Integer[] array) {
        int first = 0;
        int last = array.length - 1;

        while (first < last) {
            boolean isSorted = true;
            for (int current = 0; current < (last - first); current++) {
                int next = current + 1;
                if (array[current] > array[next]) {
                    swap(array, current, next);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            first++;
        }
    }

}