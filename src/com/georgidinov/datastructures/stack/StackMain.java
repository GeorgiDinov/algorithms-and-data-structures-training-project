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
        Integer[] stackValues = new Integer[stack.size()];

        //fill the array in reverse order to represent the stack
        int index = stackValues.length - 1;
        while (iterator.hasNext()) {
            stackValues[index--] = iterator.next();
        }

        System.out.println("Stack Elements");
        for (int i = 0; i < stackValues.length; i++) {
            ThreadColor color = (i == 0) ? ThreadColor.ANSI_GREEN : ThreadColor.ANSI_RESET; // color stack top in green
            String item = String.format("\t[%s]", stackValues[i]);
            System.out.println(MyUtil.colorMessage(item, color));
        }

    }

}