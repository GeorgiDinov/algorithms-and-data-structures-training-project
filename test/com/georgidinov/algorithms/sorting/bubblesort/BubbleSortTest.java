package com.georgidinov.algorithms.sorting.bubblesort;

import com.georgidinov.algorithms.sorting.testutil.AbstractSortingTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BubbleSortTest extends AbstractSortingTestHelper {

    private BubbleSort bubbleSort;

    @BeforeEach
    void setUp() {
        bubbleSort = new BubbleSort();
    }

    @Test
    void sortOK() {
        //given
        Integer[] array = new Integer[]{12, 3, 17, 8, 19};
        //when
        bubbleSort.sort(array);
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
                () -> bubbleSort.sort(nullArray));
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
                () -> bubbleSort.sort(emptyArray));
        //then
        String expectedMessage = "The array is empty.";
        String exceptionMessage = exception.getMessage();
        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void sortOneElementArray() {
        //given
        Integer[] oneElementArray = new Integer[]{12};
        //when
        bubbleSort.sort(oneElementArray);
        //then
        boolean isSorted = isArraySortedASC(oneElementArray);
        assertTrue(isSorted);
    }

}