package com.georgidinov.datastructures.stack;

import com.georgidinov.util.iterator.ArrayIterator;
import com.georgidinov.util.iterator.Iterator;

import java.util.EmptyStackException;

public class StackArrayImpl<T> implements Stack<T> {

    private static final int DEFAULT_SIZE = 10;

    private int top;
    private T[] stack;

    public StackArrayImpl() {
        top = 0;
        stack = (T[]) new Object[DEFAULT_SIZE];
    }

    public StackArrayImpl(int size) {
        validateStackSizeValue(size);
        top = 0;
        stack = (T[]) new Object[size];
    }

    /**
     * @return {@link com.georgidinov.util.iterator.ArrayIterator}
     * Note that this implementation starts the iteration from the first element of the array @index 0
     * which will be the reversed order for the stack elements.
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(stack);
    }

    @Override
    public void push(T value) {
        if (isEligibleToResize()) {
            doubleSize();
        }
        stack[top++] = value;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[--top];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }


    //== private methods ==
    private boolean isEligibleToResize() {
        return top == stack.length;
    }

    private void doubleSize() {
        int newLength = stack.length == 0 ? 1 : stack.length * 2;
        T[] replacingStack = (T[]) new Object[newLength];
        System.arraycopy(stack, 0, replacingStack, 0, top);
        stack = replacingStack;
    }

    private void validateStackSizeValue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Stack initialization failure. Negative value={" + size + "} was passed to the constructor.");
        }
    }

}