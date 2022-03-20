package com.georgidinov.algorithms.comparablesorting;

import com.georgidinov.util.ComparableUtil;
import com.georgidinov.util.ThreadColor;
import com.georgidinov.util.ThreadColorUtil;

import java.util.Arrays;
import java.util.Random;

public class ComparableSorterImpl {

    private static final ComparableSorter<Integer> bubbleSort = array -> {
        String name = ThreadColorUtil.colorMessage("Bubble Sort", ThreadColor.ANSI_BLUE);
        System.out.println("Sorting with " + name + " algorithm");
        for (int last = array.length - 1; last > 0; last--) {
            for (int first = 0; first < last; first++) {
                if (ComparableUtil.getInstance().isAfter(array[first], array[first + 1])) {
                    int temp = array[first + 1];
                    array[first + 1] = array[first];
                    array[first] = temp;
                }
            }
        }
    };

    private static final ComparableSorter<Integer> selectionSort = array -> {
        String name = ThreadColorUtil.colorMessage("Selection Sort", ThreadColor.ANSI_BLUE);
        System.out.println("Sorting with " + name + " algorithm");
        for (int last = array.length - 1; last > 0; last--) {
            int max = last;
            for (int current = 0; current < last; current++) {
                if (ComparableUtil.getInstance().isAfter(array[current], array[max])) {
                    max = current;
                }
            }
            int temp = array[max];
            array[max] = array[last];
            array[last] = temp;
        }
    };


    private static final ComparableSorter<Integer> insertionSort = array -> {
        String name = ThreadColorUtil.colorMessage("Insertion Sort", ThreadColor.ANSI_BLUE);
        System.out.println("Sorting with " + name + " algorithm");
        for (int first = 1; first < array.length; first++) {
            int candidate = array[first];
            int left;
            for (left = first; left > 0 && ComparableUtil.getInstance().isAfter(array[left - 1], candidate); left--) {
                array[left] = array[left - 1];
            }
            array[left] = candidate;
        }
    };

    private static final ComparableSorter<Integer> shellSort = array -> {
        String name = ThreadColorUtil.colorMessage("Shell Sort", ThreadColor.ANSI_BLUE);
        System.out.println("Sorting with " + name + " algorithm");
        for (int step = array.length / 2; step > 0; step /= 2) {
            for (int right = 0; right < array.length; right++) {
                int candidate = array[right];
                int left;
                for (left = right; left >= step && ComparableUtil.getInstance().isAfter(array[left - step], candidate); left -= step) {
                    array[left] = array[left - step];
                }
                array[left] = candidate;
            }
        }
    };


    public static void main(String[] args) {
        Integer[] array = new Integer[7];
        initPrintSortPrint(array, bubbleSort);
        initPrintSortPrint(array, selectionSort);
        initPrintSortPrint(array, insertionSort);
        initPrintSortPrint(array, shellSort);
    }


    private static void initPrintSortPrint(Integer[] array, ComparableSorter<Integer> sorter) {
        System.out.println("Unsorted");
        initIntegerArray(array);
        ThreadColorUtil.printInColor(Arrays.toString(array), ThreadColor.ANSI_RED);
        sorter.sort(array);
        ThreadColorUtil.printInColor(Arrays.toString(array), ThreadColor.ANSI_GREEN);
        System.out.println();
    }

    private static void initIntegerArray(Integer[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int value = random.nextInt(50);
            array[i] = value;
        }
    }
}