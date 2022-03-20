package com.georgidinov.datastructures.iterator.impl;

import com.georgidinov.datastructures.iterator.Iterator;
import com.georgidinov.datastructures.node.SingleLinkedListNode;

public class ListIterator<T extends Comparable<T>> implements Iterator<T> {


    SingleLinkedListNode<T> head;

    public ListIterator(SingleLinkedListNode<T> head) {
        this.head = head;
    }


    @Override
    public boolean hasNext() {
        return head != null;
    }

    @Override
    public T next() {
        T value = head.getValue();
        head = head.getNext();
        return value;
    }

}