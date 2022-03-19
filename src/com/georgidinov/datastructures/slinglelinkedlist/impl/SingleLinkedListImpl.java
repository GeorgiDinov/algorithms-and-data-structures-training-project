package com.georgidinov.datastructures.slinglelinkedlist.impl;

import com.georgidinov.datastructures.iterator.Iterator;
import com.georgidinov.datastructures.node.SingleLinkedListNode;
import com.georgidinov.datastructures.node.impl.Node;
import com.georgidinov.datastructures.slinglelinkedlist.SingleLinkedList;

import java.util.NoSuchElementException;

public class SingleLinkedListImpl<T extends Comparable<T>> implements SingleLinkedList<T> {

    private int size;
    private SingleLinkedListNode<T> head;
    private SingleLinkedListNode<T> tail;

    public SingleLinkedListImpl() {
    }

    public SingleLinkedListImpl(int size) {
        this.size = size;
        this.head = null;
        this.tail = null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
            tail = head;
        } else {
            SingleLinkedListNode<T> newNode = new Node<>(value);
            newNode.setNext(head);
            head = newNode;

        }
        size++;
    }

    @Override
    public T remove() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("No such element");
        }
        SingleLinkedListNode<T> temp1 = head;
        SingleLinkedListNode<T> temp2 = null;
        if (temp1.getNext() == null) {
            temp1 = temp1.getNext();
            temp1.setNext(null);
            throw new NoSuchElementException("No such element");
        }
        temp2 = temp1;
        while (temp2.getNext() == null) {
            return temp2.getValue();
        }
        temp2.setNext(null);
        size--;
        return null;
    }

    @Override
    public T removeFromFront() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("No such element");
        }
        SingleLinkedListNode<T> removed = head;
        head = head.getNext();
        removed.setNext(null);
        size--;
        return removed.getValue();

    }

    @Override
    public boolean contains(T value) {
        return false;
    }

}
