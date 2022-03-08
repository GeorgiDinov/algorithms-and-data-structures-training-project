package com.georgidinov.datastructures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackArrayImplTest {


    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new StackArrayImpl<>();
    }

    @Test
    void createStackFailure() {
        int stackSize = -1;
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> stack = new StackArrayImpl<>(stackSize));
        String expectedMessage = "Stack initialization failure. Negative value={" + stackSize + "} was passed to the constructor.";
        String exceptionMessage = exception.getMessage();
        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void createStackWithZeroCapacity() {
        int size = 0;
        stack = new StackArrayImpl<>(size);
        stack.push(size);
        stack.push(size);
        stack.peek();
        stack.pop();
        stack.push(size);
        stack.peek();
        stack.push(size);
        assertEquals(3, stack.size());
    }

    @Test
    void push() {
        int value = 5;
        stack.push(value);
        assertEquals(1, stack.size());
    }

    @Test
    void pop() {
        int value = 5;
        int secondValue = 10;
        stack.push(value);
        stack.push(secondValue);
        int poppedValue = stack.pop();
        assertEquals(secondValue, poppedValue);
        assertEquals(1, stack.size());
    }

    @Test
    void popEmptyStack() {
        Exception exception = assertThrows(EmptyStackException.class,
                () -> stack.pop());
        assertNotNull(exception);
    }

    @Test
    void peek() {
        int value = 5;
        int secondValue = 10;
        stack.push(value);
        stack.push(secondValue);
        int peekedValue = stack.peek();
        assertEquals(secondValue, peekedValue);
        assertEquals(2, stack.size());
    }

    @Test
    void peekEmptyStack() {
        Exception exception = assertThrows(EmptyStackException.class,
                () -> stack.peek());
        assertNotNull(exception);
    }

    @Test
    void size() {
        assertEquals(0, stack.size());
    }

    @Test
    void sizeWhenStackUsed() {
        int pushCounter = 5;
        for (int i = 0; i < pushCounter; i++) {
            stack.push(pushCounter);
            stack.peek();
        }

        int popCounter = 2;
        for (int i = 0; i < popCounter; i++) {
            stack.pop();
            stack.peek();
        }

        stack.peek();

        assertEquals(pushCounter - popCounter, stack.size());
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void isNotEmpty() {
        stack.push(5);
        stack.peek();
        assertFalse(stack.isEmpty());
    }
}