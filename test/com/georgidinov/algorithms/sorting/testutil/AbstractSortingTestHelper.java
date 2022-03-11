package com.georgidinov.algorithms.sorting.testutil;

public abstract class AbstractSortingTestHelper {

    public boolean isArraySortedASC(Integer[] array) {
        if (array.length == 1) {
            return true;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

}