package com.georgidinov.datastructures.node;

public interface SingleLinkedListNode<T extends Comparable<T>> extends NodeValue<T> {

    void setNext(SingleLinkedListNode<T> next);

    SingleLinkedListNode<T> getNext();

}