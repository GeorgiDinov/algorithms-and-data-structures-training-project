package com.georgidinov.algorithms.stack;

import java.util.Random;

public class StackMain {


    public static void main(String[] args) {

        StackMain main = new StackMain();

        Stack<Double> stackImpl = new StackImpl<>();
        main.initIntegerStack(stackImpl);
        stackImpl.print();

    }


    private <T> void initIntegerStack(Stack<T> stack) {
        for (int i = 0; i < 5; i++) {
            Integer value = new Random().nextInt(10);
            stack.push((T) value);
        }
    }

}