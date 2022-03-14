package com.georgidinov.datastructures.doublelinkedlist.impl;

import com.georgidinov.datastructures.doublelinkedlist.DoubleLinkedList;
import com.georgidinov.datastructures.iterator.Iterator;
import com.georgidinov.datastructures.iterator.impl.ListIterator;
import com.georgidinov.datastructures.node.DoubleLinkedListNode;
import com.georgidinov.datastructures.node.impl.Node;

import java.util.NoSuchElementException;

import static com.georgidinov.util.ProjectConstants.EMPTY_LIST_EXCEPTION_MESSAGE;

public class DoublyLinkedList<T extends Comparable<T>> implements DoubleLinkedList<T> {

    private int size;
    private DoubleLinkedListNode<T> head;
    private DoubleLinkedListNode<T> tail;


    public DoublyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(head);
    }

    @Override
    public void add(T value) {
        addLast(value);
    }

    @Override
    public T remove() {
        return removeLast();
    }

    @Override
    public void addFirst(T value) {
        if (head == null) {
            head = new Node<>(value);
            tail = head;
        } else {
            DoubleLinkedListNode<T> newNode = new Node<>(value);
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        DoubleLinkedListNode<T> removed = head;
        head = head.getNext();
        removed.setNext(null);
        if (head != null) {
            head.setPrevious(null);
        }
        size--;
        return removed.getValue();
    }

    @Override
    public void addLast(T value) {
        if (head == null) {
            tail = new Node<>(value);
            head = tail;
        } else {
            DoubleLinkedListNode<T> newNode = new Node<>(value);
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        DoubleLinkedListNode<T> removed = tail;
        tail = tail.getPrevious();
        removed.setPrevious(null);
        if (tail != null) {
            tail.setNext(null);
        }
        size--;
        return removed.getValue();
    }

    @Override
    public T peekFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        return head.getValue();
    }

    @Override
    public T peekLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        return tail.getValue();
    }

    @Override
    public boolean contains(T value) {
        if (this.isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        DoubleLinkedListNode<T> first = head;
        DoubleLinkedListNode<T> last = tail;
        if (first == last) {
            return value == first.getValue();
        }
        while (first != last) {
            if (first.getValue() == value || last.getValue() == value) {
                return true;
            }
            first = first.getNext();
            last = last.getPrevious();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}