package com.georgidinov.algorithms.sorting.selectionsort;

import com.georgidinov.algorithms.sorting.AbstractSorter;
import com.georgidinov.util.ThreadColor;

public class SelectionSort extends AbstractSorter<Integer> {


    public static void main(String[] args) {
        Integer[] array = new Integer[]{3, 6, 12, 1, 11, 18};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.printArrayInColor(array, ThreadColor.ANSI_RED);
        selectionSort.sort(array);
        selectionSort.printArrayInColor(array, ThreadColor.ANSI_GREEN);
    }

    @Override
    public void sort(Integer[] array) {
        validateArrayEligibilityForSorting(array);
        if (isArrayWithOneElement(array)) {
            System.out.println(SINGLE_ELEMENT_ARRAY_MESSAGE);
            return;
        }
        selectionSortImpl(array);
    }

    private void selectionSortImpl(Integer[] array) {
        for (int last = array.length - 1; last > 0; last--) {
            int max = last;
            for (int i = 0; i < last; i++) {
                if (array[i] > array[max]) {
                    max = i;
                }
            }
            swap(array, max, last);
        }
    }

    public void sortAscending(Integer[] array) {
        for (int first = 0; first < array.length - 1; first++) {
            int min = first;
            for (int current = first + 1; current < array.length; current++) {
                if (array[min] > array[current]) {
                    min = current;
                }
            }
            swap(array, min, first);

        }
    }

    public void sortDescending(Integer[] array) {
        for (int first = 0; first < array.length - 1; first++) {
            int max = first;
            for (int current = first + 1; current < array.length; current++) {
                if (array[max] < array[current]) {
                    max = current;
                }
            }
            swap(array, max, first);
        }
    }

}