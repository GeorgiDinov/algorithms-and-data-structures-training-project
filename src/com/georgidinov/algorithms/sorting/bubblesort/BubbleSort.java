package com.georgidinov.algorithms.sorting.bubblesort;

import com.georgidinov.algorithms.sorting.AbstractSorter;
import com.georgidinov.util.MyUtil;
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
        //bubbleSortImplOne(array);
        bubbleSortImplTwo(array);
        //bubbleSortImplThree(array);
    }


    //== different implementations of the algorithm ==
    private void bubbleSortImplOne(Integer[] array) {
        for (int last = array.length - 1; last > 0; last--) {
            for (int current = 0; current < last; current++) {
                int next = current + 1;
                if (array[current] > array[next]) {
                    swap(array, current, next);
                }
            }
        }
    }

    private void bubbleSortImplTwo(Integer[] array) {
        int first = 0;
        int last = array.length - 1;
        IntStream
                .range(first, last)
                .flatMap(index -> {
                    MyUtil.printInColor("index=" + index + ", last=" + (last - index), ThreadColor.ANSI_BLUE);
                    return IntStream.range(first, last - index);
                })
                .forEach(current -> {
                    int next = current + 1;
                    System.out.println("current=" + array[current] + ", next=" + array[next]);
                    if (array[current] > array[next]) {
                        swap(array, (current), next);
                    }
                });
    }

    private void bubbleSortImplThree(Integer[] array) {
        int i = 0, n = array.length;

        boolean swapNeeded = true;
        while (i < n - 1 && swapNeeded) {
            swapNeeded = false;
            for (int j = 1; j < n - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, (j - 1), j);
                    swapNeeded = true;
                }
            }
            if (!swapNeeded) {
                break;
            }
            i++;
        }
    }

}