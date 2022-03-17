package com.georgidinov.datastructures.doublelinkedlist;

import com.georgidinov.datastructures.doublelinkedlist.impl.DoubleLinkedListImpl;
import com.georgidinov.datastructures.iterator.Iterator;

public class DoubleLinkedListMain {

    public static void main(String[] args) {

        DoubleLinkedList<Integer> list = new DoubleLinkedListImpl<>();
        list.add(5);
        list.add(10);
        list.add(15);
        Iterator<Integer> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }

    }

}