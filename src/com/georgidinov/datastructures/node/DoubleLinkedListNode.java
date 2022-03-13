package com.georgidinov.datastructures.node;

public interface DoubleLinkedListNode<T extends Comparable<T>> extends NodeValue<T> {

    void setNext(DoubleLinkedListNode<T> next);

    DoubleLinkedListNode<T> getNext();

    void setPrevious(DoubleLinkedListNode<T> previous);

    DoubleLinkedListNode<T> getPrevious();

}