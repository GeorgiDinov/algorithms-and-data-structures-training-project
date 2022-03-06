package com.georgidinov.datastructures.stack;

import java.util.EmptyStackException;

import static com.georgidinov.util.ThreadColor.ANSI_GREEN;
import static com.georgidinov.util.ThreadColor.ANSI_RESET;

public class StackArrayImpl<T> implements Stack<T> {

    private static final int DEFAULT_SIZE = 10;

    private int top;
    private T[] stack;

    public StackArrayImpl() {
        top = 0;
        // this is not appropriate initialization, but for training/ educational purposes it will do the job
        // alternatives of this initialization could be
        //1. use reflection and pass type 'Class<T> clazz' to the constructor and initialize the array like this -> 'stack = (T[]) Array.newInstance(clazz, size);'
        //2. create as many implementations you want by explicitly write the type the stack will work with e.g. '... implements Stack<Integer>'
        //3. use different underlying data structure than array like LinkedList or ArrayList if you wish the benefits of generics.
        stack = (T[]) new Object[DEFAULT_SIZE];
    }

    public StackArrayImpl(int size) {
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
        String topElementPlaceHolder = ANSI_GREEN.getColor() + elementPlaceHolder + ANSI_RESET.getColor();

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