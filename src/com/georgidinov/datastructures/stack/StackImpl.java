package com.georgidinov.datastructures.stack;

import java.security.InvalidParameterException;
import java.util.EmptyStackException;

import static com.georgidinov.util.ThreadColor.ANSI_GREEN;
import static com.georgidinov.util.ThreadColor.ANSI_RESET;

public class StackImpl<T> implements Stack<T> {

    private static final int DEFAULT_SIZE = 10;

    private int top;
    private T[] stack;

    public StackImpl() {
        top = 0;
        stack = (T[]) new Object[DEFAULT_SIZE];
    }

    public StackImpl(int size) {
        validateStackSizeValue(size);
        top = 0;
        stack = (T[]) new Object[size];
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

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("Stack Elements\n");

        String elementPlaceHolder = "\t[%s]";
        String topElementPlaceHolder = ANSI_GREEN + elementPlaceHolder + ANSI_RESET;

        for (int element = top - 1; element >= 0; element--) {
            if ((element == top - 1)) {
                sb.append(String.format(topElementPlaceHolder, stack[element])).append("\n");
            } else {
                sb.append(String.format(elementPlaceHolder, stack[element])).append("\n");
            }
        }
        System.out.println(sb);
    }

    //== private methods ==
    private boolean isEligibleToResize() {
        return top == stack.length;
    }

    private void doubleSize() {
        T[] replacingStack = (T[]) new Object[2 * stack.length];
        System.arraycopy(stack, 0, replacingStack, 0, top);
        stack = replacingStack;
    }

    private void validateStackSizeValue(int size) {
        if (size < 1) {
            throw new InvalidParameterException("Stack initialization failure. The value{" + size + "} was passed to the constructor. Please provide value >= 1");
        }
    }

}