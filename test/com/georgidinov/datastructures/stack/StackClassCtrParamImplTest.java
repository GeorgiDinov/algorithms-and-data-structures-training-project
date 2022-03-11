package com.georgidinov.datastructures.stack;

import com.georgidinov.util.iterator.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackClassCtrParamImplTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new StackClassCtrParamImpl<>(Integer.class);
    }

    @Test
    void createStackFailure() {
        //given
        int stackSize = -1;
        //when
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> stack = new StackClassCtrParamImpl<>(Integer.class, stackSize));
        //then
        String expectedMessage = "Stack initialization failure. Negative value={" + stackSize + "} was passed to the constructor.";
        String exceptionMessage = exception.getMessage();
        assertEquals(expectedMessage, exceptionMessage);
    }

    @Test
    void createStackWithZeroCapacity() {
        //given
        int size = 0;
        stack = new StackArrayImpl<>(size);
        //when
        stack.push(size);
        stack.push(size);
        stack.peek();
        stack.pop();
        stack.push(size);
        stack.peek();
        stack.push(size);
        //then
        assertEquals(3, stack.size());
    }

    @Test
    void getIteratorEmptyStack() {
        //given
        Iterator<Integer> iterator = stack.iterator();
        //then
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
    }

    @Test
    void getIteratorStackOneElement() {
        //given
        int value = 1;
        stack.push(value);
        //when
        Iterator<Integer> iterator = stack.iterator();
        //then
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());

        int next = iterator.next();
        assertEquals(value, next);
        assertFalse(iterator.hasNext());
    }

    @Test
    void getIteratorStackMoreThanOneElement() {
        //given
        int firstValue = 1;
        int secondValue = 2;
        int thirdValue = 3;
        stack.push(firstValue);         //[3]<- top
        stack.push(secondValue);        //[2]
        stack.push(thirdValue);         //[1]
        //when
        Iterator<Integer> iterator = stack.iterator();
        //then
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());

        int next = iterator.next();// [3]
        assertEquals(thirdValue, next);
        assertTrue(iterator.hasNext());

        next = iterator.next();// [2]
        assertEquals(secondValue, next);
        assertTrue(iterator.hasNext());
    }

    @Test
    void push() {
        //given
        int value = 5;
        //when
        stack.push(value);
        //then
        assertEquals(1, stack.size());
    }

    @Test
    void pop() {
        //given
        int value = 5;
        int secondValue = 10;
        //when
        stack.push(value);
        stack.push(secondValue);
        //then
        int poppedValue = stack.pop();
        assertEquals(secondValue, poppedValue);
        assertEquals(1, stack.size());
    }

    @Test
    void popEmptyStack() {
        //when
        Exception exception = assertThrows(EmptyStackException.class,
                () -> stack.pop());
        //then
        assertNotNull(exception);
    }

    @Test
    void peek() {
        //given
        int value = 5;
        int secondValue = 10;
        //when
        stack.push(value);
        stack.push(secondValue);
        //then
        int peekedValue = stack.peek();
        assertEquals(secondValue, peekedValue);
        assertEquals(2, stack.size());
    }

    @Test
    void peekEmptyStack() {
        //when
        Exception exception = assertThrows(EmptyStackException.class,
                () -> stack.peek());
        //then
        assertNotNull(exception);
    }

    @Test
    void size() {
        //when then
        assertEquals(0, stack.size());
    }

    @Test
    void sizeWhenStackUsed() {
        //given
        int pushCounter = 5;
        //when
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
        //then
        assertEquals(pushCounter - popCounter, stack.size());
    }

    @Test
    void isEmpty() {
        //when then
        assertTrue(stack.isEmpty());
    }

    @Test
    void isNotEmpty() {
        //when
        stack.push(5);
        stack.peek();
        //then
        assertFalse(stack.isEmpty());
    }
}