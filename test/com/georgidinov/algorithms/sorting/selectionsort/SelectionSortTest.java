package com.georgidinov.algorithms.sorting.selectionsort;

import com.georgidinov.algorithms.sorting.testutil.AbstractSortingTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SelectionSortTest extends AbstractSortingTestHelper {

    private SelectionSort selectionSort;

    @BeforeEach
    void setUp() {
        selectionSort = new SelectionSort();
    }

    @Test
    void sortOK() {
        //given
        Integer[] array = new Integer[]{15, 11, 8, 5, 3};
        //when
        selectionSort.sort(array);
        //then
        boolean isSorted = isArraySortedASC(array);
        assertTrue(isSorted);
    }

    @Test
    void sortNullArray() {
        //given
        Integer[] nullArray = null;
        //when
        Exception exception = assertThrows(RuntimeException.class,
                () -> selectionSort.sort(nullArray));
        //then
        String expectedMessage = "The array is not initialized.";
        String exceptionMessage = exception.getMessage();
        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void sortEmptyArray() {
        //given
        Integer[] emptyArray = new Integer[]{};
        //when
        Exception exception = assertThrows(RuntimeException.class,
                () -> selectionSort.sort(emptyArray));
        //then
        String expectedMassage = "The array is empty.";
        String exceptionMassage = exception.getMessage();
        assertEquals(expectedMassage, exceptionMassage);
    }

    @Test
    void sortOneElementArray() {
        //given
        Integer[] oneElementArray = new Integer[]{15};
        //when
        selectionSort.sort(oneElementArray);
        //then
        boolean isSorted = isArraySortedASC(oneElementArray);
        assertTrue(isSorted);
    }
}