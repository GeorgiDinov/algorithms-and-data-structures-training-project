package com.georgidinov.datastructures.list.impl;

import com.georgidinov.datastructures.iterator.Iterator;
import com.georgidinov.datastructures.iterator.impl.ListIterator;
import com.georgidinov.datastructures.list.List;
import com.georgidinov.datastructures.node.SingleLinkedListNode;
import com.georgidinov.datastructures.node.impl.Node;
import com.georgidinov.util.ComparableUtil;

import java.util.NoSuchElementException;

import static com.georgidinov.util.ProjectConstants.EMPTY_LIST_EXCEPTION_MESSAGE;

public class SingleLinkedList<T extends Comparable<T>> implements List<T> {

    private int size;
    private SingleLinkedListNode<T> head;

    public SingleLinkedList() {
        this.size = 0;
        this.head = null;
    }

    @Override
    public void add(T value) {
        addLast(value);
    }

    @Override
    public void addFirst(T value) {
        if (isEmpty()) {
            head = new Node<>(value);
        } else {
            SingleLinkedListNode<T> newNode = new Node<>(value);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T value) {
        if (isEmpty()) {
            head = new Node<>(value);
        } else {
            SingleLinkedListNode<T> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node<>(value));
        }
        size++;
    }

    @Override
    public void addInOrder(T value) {
        if (isEmpty()) {
            addLast(value);
            return;
        }

        if (ComparableUtil.getInstance().isAfter(head.getValue(), value)) {
            addFirst(value);
            return;
        }

        SingleLinkedListNode<T> previous = head;
        SingleLinkedListNode<T> next = head.getNext();

        while (next != null && ComparableUtil.getInstance().isBefore(next.getValue(), value)) {
            previous = previous.getNext();
            next = next.getNext();
        }

        SingleLinkedListNode<T> nodeToInsert = new Node<>(value);
        previous.setNext(nodeToInsert);
        nodeToInsert.setNext(next);
        size++;
    }

    @Override
    public T remove() {
        return removeLast();
    }

    @Override
    public T removeFirst() {
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
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        if (size == 1) {
            T value = head.getValue();
            head = null;
            size--;
            return value;
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
    public T peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        return head.getValue();
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        SingleLinkedListNode<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getValue();
    }


    //== DataStructure<T> implementations ==
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
    public boolean contains(T value) {
        if (this.isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        SingleLinkedListNode<T> current = head;
        while (current.getNext() != null) {
            if (ComparableUtil.getInstance().isEqual(current.getValue(), value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

}