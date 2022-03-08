package com.georgidinov.datastructures.stack;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class StackClassCtrParamImpl<T> {

    public static final int DEFAULT_STACK_CAPACITY = 10;

    int top;
    T[] stack;

    public StackClassCtrParamImpl(Class<T> clazz) {
        this.top = 0;
        this.stack = (T[]) Array.newInstance(clazz, DEFAULT_STACK_CAPACITY);
    }

    public StackClassCtrParamImpl(Class<T> clazz, int capacity) {
        validateCapacity(capacity);
        this.top = 0;
        this.stack = (T[]) Array.newInstance(clazz, capacity);
    }


    public void push(T value) {
        if (isEligibleToResize()) {
            doubleSize();
        }
        stack[top++] = value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[--top];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }


    //== private methods ==
    private boolean isEligibleToResize() {
        return top == stack.length;
    }

    private void doubleSize() {
        int newLength = stack.length == 0 ? 1 : stack.length * 2;
        T[] replacingStack = (T[]) Array.newInstance(stack.getClass(), newLength);
        System.arraycopy(stack, 0, replacingStack, 0, top);
        stack = replacingStack;
    }

    private void validateCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Stack initialization failure. Negative value={" + capacity + "} was passed to the constructor.");
        }
    }

}