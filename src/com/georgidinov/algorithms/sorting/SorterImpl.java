package com.georgidinov.algorithms.sorting;

import com.georgidinov.util.ThreadColor;
import com.georgidinov.util.ThreadColorUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * Created for the ease of training, having all algorithms in one place like lambdas/anonymous classes.
 */
public class SorterImpl {

    private static final Sorter<Integer> bubbleSort = array -> {
        String name = ThreadColorUtil.colorMessage("Bubble Sort", ThreadColor.ANSI_BLUE);
        System.out.println("Sorting with " + name + " algorithm");
        for (int last = array.length - 1; last > 0; last--) {
            for (int first = 0; first < last; first++) {
                if (array[first] > array[first + 1]) {
                    int temp = array[first + 1];
                    array[first + 1] = array[first];
                    array[first] = temp;
                }
            }
        }
    };

    private static final Sorter<Integer> selectionSort = array -> {
        String name = ThreadColorUtil.colorMessage("Selection Sort", ThreadColor.ANSI_BLUE);
        System.out.println("Sorting with " + name + " algorithm");
        for (int last = array.length - 1; last > 0; last--) {
            int max = last;
            for (int current = 0; current < last; current++) {
                if (array[current] > array[max]) {
                    max = current;
                }
            }
            int temp = array[max];
            array[max] = array[last];
            array[last] = temp;
        }
    };


    private static final Sorter<Integer> insertionSort = array -> {
        String name = ThreadColorUtil.colorMessage("Insertion Sort", ThreadColor.ANSI_BLUE);
        System.out.println("Sorting with " + name + " algorithm");
        for (int first = 1; first < array.length; first++) {
            int candidate = array[first];
            int left;
            for (left = first; left > 0 && array[left - 1] > candidate; left--) {
                array[left] = array[left - 1];
            }
            array[left] = candidate;
        }
    };

    private static final Sorter<Integer> shellSort = array -> {
        String name = ThreadColorUtil.colorMessage("Shell Sort", ThreadColor.ANSI_BLUE);
        System.out.println("Sorting with " + name + " algorithm");
        for (int step = array.length / 2; step > 0; step /= 2) {
            for (int right = 0; right < array.length; right++) {
                int candidate = array[right];
                int left;
                for (left = right; left >= step && array[left - step] > candidate; left -= step) {
                    array[left] = array[left - step];
                }
                array[left] = candidate;
            }
        }
    };

    //== anonymous class implementation ==
    private static final Sorter<Integer> quickSort = new Sorter<>() {
        @Override
        public void sort(Integer[] array) {
            String name = ThreadColorUtil.colorMessage("Quick Sort", ThreadColor.ANSI_BLUE);
            System.out.println("Sorting with " + name + " algorithm");
            quickSort(array, 0, array.length);
        }

        private void quickSort(Integer[] array, int start, int end) {
            if (end - start < 2) {
                return;
            }
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex);
            quickSort(array, pivotIndex + 1, end);
        }

        private int partition(Integer[] array, int start, int end) {
            int pivot = array[start];
            int i = start;
            int j = end;
            while (i < j) {
                while (i < j && array[--j] > pivot) ;
                if (i < j) {
                    array[i] = array[j];
                }
                while (i < j && array[++i] < pivot) ;
                if (i < j) {
                    array[j] = array[i];
                }
            }
            array[j] = pivot;
            return j;
        }
    };

    //== anonymous class implementation ==
    private static final Sorter<Integer> mergeSort = new Sorter<>() {
        @Override
        public void sort(Integer[] array) {
            String name = ThreadColorUtil.colorMessage("Merge Sort", ThreadColor.ANSI_BLUE);
            System.out.println("Sorting with " + name + " algorithm");
            mergeSort(array, 0, array.length);
        }

        private void mergeSort(Integer[] array, int start, int end) {
            if (end - start < 2) {
                return;
            }
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid, end);
            merge(array, start, mid, end);
        }

        private void merge(Integer[] array, int start, int mid, int end) {
            if (array[mid - 1] <= array[mid]) {
                return;
            }
            int i = start;
            int j = mid;
            int tempIndex = 0;
            Integer[] temp = new Integer[end - start];
            while (i < mid && j < end) {
                temp[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
            }
            System.arraycopy(array, i, array, start + tempIndex, mid - i);
            System.arraycopy(temp, 0, array, start, tempIndex);
        }
    };


    public static void main(String[] args) {
        Integer[] array = new Integer[7];
        initPrintSortPrint(array, bubbleSort);
        initPrintSortPrint(array, selectionSort);
        initPrintSortPrint(array, insertionSort);
        initPrintSortPrint(array, shellSort);
        initPrintSortPrint(array, mergeSort);
        initPrintSortPrint(array, quickSort);
    }


    private static void initPrintSortPrint(Integer[] array, Sorter<Integer> sorter) {
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