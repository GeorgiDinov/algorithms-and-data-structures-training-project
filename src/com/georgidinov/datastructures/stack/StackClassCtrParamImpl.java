package com.georgidinov.datastructures.stack;

import com.georgidinov.util.iterator.ArrayIterator;
import com.georgidinov.util.iterator.Iterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class StackClassCtrParamImpl<T> implements Stack<T> {

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


    @Override
    public Iterator<T> iterator() {
        T[] reversedStack = reverseStack();
        return new ArrayIterator<>(reversedStack);
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

    private T[] reverseStack() {
        T[] copy = Arrays.copyOf(stack, top);
        int last = copy.length - 1;
        for (int i = 0; i < copy.length / 2; i++) {
            T temp = copy[i];
            copy[i] = copy[last];
            copy[last--] = temp;
        }
        return copy;
    }

}