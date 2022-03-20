package com.georgidinov.datastructures.slinglelinkedlist.impl;

import com.georgidinov.datastructures.iterator.Iterator;
import com.georgidinov.datastructures.iterator.impl.ListIterator;
import com.georgidinov.datastructures.node.SingleLinkedListNode;
import com.georgidinov.datastructures.node.impl.Node;
import com.georgidinov.datastructures.slinglelinkedlist.SingleLinkedList;

import java.util.NoSuchElementException;

import static com.georgidinov.util.ProjectConstants.EMPTY_LIST_EXCEPTION_MESSAGE;

public class SingleLinkedListImpl<T extends Comparable<T>> implements SingleLinkedList<T> {

    private int size;
    private SingleLinkedListNode<T> head;
    private SingleLinkedListNode<T> tail;

    public SingleLinkedListImpl() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(head);
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
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
    }

    public void addFirst(T value) {
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

    //== adds with iteration through all elements and insert new node at the end
    private void addIteratingThroughList(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            SingleLinkedListNode<T> newNode = new Node<>(value);
            SingleLinkedListNode<T> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    @Override
    public T remove() {
        if (this.isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        if (size == 1) {
            T val = head.getValue();
            head = null;
            tail = null;
            size--;
            return val;
        }
        SingleLinkedListNode<T> current = head;
        SingleLinkedListNode<T> next = current.getNext();

        while (next.getNext() != null) {
            current = current.getNext();
            next = next.getNext();
        }

        T value = next.getValue();
        current.setNext(null);
        size--;
        return value;
    }

    @Override
    public T removeFromFront() {
        if (this.isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        SingleLinkedListNode<T> removed = head;
        head = head.getNext();
        removed.setNext(null);
        size--;
        return removed.getValue();
    }

    @Override
    public boolean contains(T value) {
        if (this.isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        SingleLinkedListNode<T> current = head;
        while (current.getNext() != null) {
            if (current.getValue().compareTo(value) == 0) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

}
