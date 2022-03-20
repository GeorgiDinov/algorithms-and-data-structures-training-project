package com.georgidinov.datastructures.list;

import com.georgidinov.datastructures.iterator.Iterator;

import java.util.Random;

public class ListMain {

    public static void main(String[] args) {
    }

    private static void initList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            Integer integer = new Random().nextInt(50);
            list.add(integer);
        }
    }


    private static void initListInOrder(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            Integer integer = new Random().nextInt(50);
            list.addInOrder(integer);
        }
    }

    private static void printList(List<Integer> list) {
        Iterator<Integer> listIterator = list.iterator();
        System.out.print("List=");
        while (listIterator.hasNext()) {
            System.out.print(" " + listIterator.next());
        }
        System.out.println();
    }

}
