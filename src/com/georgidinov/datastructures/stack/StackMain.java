package com.georgidinov.datastructures.stack;

import com.georgidinov.datastructures.stack.impl.StackArrayImpl;
import com.georgidinov.datastructures.stack.impl.StackClassCtrParamImpl;
import com.georgidinov.util.MyUtil;
import com.georgidinov.util.ThreadColor;
import com.georgidinov.datastructures.iterator.Iterator;

public class StackMain {


    public static void main(String[] args) {
        Stack<Integer> stack = new StackArrayImpl<>();
        Stack<Integer> stackCtrClazz = new StackClassCtrParamImpl<>(Integer.class);
        initIntegerStack(stack);
        initIntegerStack(stackCtrClazz);
        printIntegerStack(stack);
        System.out.println();
        printIntegerStack(stackCtrClazz);
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