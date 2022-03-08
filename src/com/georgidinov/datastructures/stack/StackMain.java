package com.georgidinov.datastructures.stack;

import com.georgidinov.util.MyUtil;
import com.georgidinov.util.ThreadColor;
import com.georgidinov.util.iterator.Iterator;

public class StackMain {


    public static void main(String[] args) {
        Stack<Integer> stack = new StackArrayImpl<>();
        initIntegerStack(stack);
        printIntegerStack(stack);
    }


    private static void initIntegerStack(Stack<Integer> stack) {
        for (int i = 0; i < 5; i++) {
            stack.push(i + 1);
        }
    }

    private static void printIntegerStack(Stack<Integer> stack) {
        Iterator<Integer> iterator = stack.iterator();
        System.out.println("Stack Elements");

        int iteration = 0;
        while (iterator.hasNext()) {
            ThreadColor messageColor = (iteration++ == 0) ? ThreadColor.ANSI_GREEN : ThreadColor.ANSI_RESET; // color stack top in green
            String element = String.format("\t[%s]", iterator.next());
            System.out.println(MyUtil.colorMessage(element, messageColor));
        }
    }

}