package com.georgidinov.datastructures.list.impl;

import com.georgidinov.datastructures.list.List;
import com.georgidinov.datastructures.iterator.Iterator;
import com.georgidinov.datastructures.iterator.impl.ListIterator;
import com.georgidinov.datastructures.node.DoubleLinkedListNode;
import com.georgidinov.datastructures.node.impl.Node;
import com.georgidinov.util.ComparableUtil;

import java.util.NoSuchElementException;

import static com.georgidinov.util.ProjectConstants.EMPTY_LIST_EXCEPTION_MESSAGE;

public class DoubleLinkedList<T extends Comparable<T>> implements List<T> {

    private int size;
    private DoubleLinkedListNode<T> head;
    private DoubleLinkedListNode<T> tail;


    public DoubleLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }


    @Override
    public void add(T value) {
        addLast(value);
    }


    @Override
    public void addFirst(T value) {
        if (isEmpty()) {
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
    public void addInOrder(T value) {
        if (isEmpty()) {
            add(value);
            return;
        }

        if (ComparableUtil.getInstance().isAfter(head.getValue(), value)) {
            addFirst(value);
            return;
        }

        DoubleLinkedListNode<T> previous = head;
        DoubleLinkedListNode<T> next = head.getNext();

        while (next != null && ComparableUtil.getInstance().isBefore(next.getValue(), value)) {
            previous = previous.getNext();
            next = next.getNext();
        }

        DoubleLinkedListNode<T> nodeToInsert = new Node<>(value);

        previous.setNext(nodeToInsert);
        nodeToInsert.setPrevious(previous);

        nodeToInsert.setNext(next);
        if (next != null) {
            next.setPrevious(nodeToInsert);
        } else {
            tail = nodeToInsert;
        }

        size++;
    }

    @Override
    public T remove() {
        return removeLast();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
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
        if (isEmpty()) {
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
        if (isEmpty()) {
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
        return tail.getValue();
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
        if (isEmpty()) {
            throw new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }
        DoubleLinkedListNode<T> first = head;
        DoubleLinkedListNode<T> last = tail;
        if (first == last) {
            return ComparableUtil.getInstance().isEqual(first.getValue(), value);
        }
        while (first != last) {
            if (ComparableUtil.getInstance().isEqual(first.getValue(), value)
                    || ComparableUtil.getInstance().isEqual(last.getValue(), value)) {
                return true;
            }
            first = first.getNext();
            last = last.getPrevious();
        }
        return false;
    }

}