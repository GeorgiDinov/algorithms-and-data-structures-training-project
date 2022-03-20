package com.georgidinov.datastructures.slinglelinkedlist;

import com.georgidinov.datastructures.iterator.Iterator;
import com.georgidinov.datastructures.slinglelinkedlist.impl.SingleLinkedListImpl;

public class SingleLinkedListMain {

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedListImpl<>();

        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        printList(list);
        while (list.size() != 0) {
            System.out.print(list.remove() + " ");
        }
        System.out.println();
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        printList(list);
        while (list.size() != 0) {
            System.out.print(list.removeFromFront() + " ");
        }

//        System.out.println();
//        System.out.println(list.remove());
//        System.out.println(list.removeFromFront());
//        System.out.println(list.size());
//        System.out.println(list.contains(7));
//        System.out.println(list.contains(8));
//        System.out.println(list.contains(9));
    }

    private static void printList(SingleLinkedList<Integer> list) {
        Iterator<Integer> listIterator = list.iterator();
        System.out.print("List=");
        while (listIterator.hasNext()) {
            System.out.print(" " + listIterator.next());
        }
        System.out.println();
    }
}
