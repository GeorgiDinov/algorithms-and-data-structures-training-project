package com.georgidinov.datastructures.queue.impl;

import com.georgidinov.datastructures.iterator.Iterator;
import com.georgidinov.datastructures.iterator.impl.ArrayIterator;
import com.georgidinov.datastructures.queue.Queue;
import com.georgidinov.util.ComparableUtil;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static com.georgidinov.util.ProjectConstants.DEFAULT_CAPACITY;

public class QueueArrayImpl<T extends Comparable<T>> implements Queue<T> {

    private int front;
    private int back;
    private T[] queue;

    public QueueArrayImpl() {
        this.front = 0;
        this.back = 0;
        this.queue = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public QueueArrayImpl(int capacity) {
        validateCapacity(capacity);
        this.front = 0;
        this.back = 0;
        this.queue = (T[]) new Comparable[capacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(copyQueue(queue.length));
    }

    @Override
    public void add(T value) {
        if (isEligibleToResize()) {
            doubleSize();
        }
        queue[back] = value;
        if (back == queue.length - 1) {
            back = 0;
        } else {
            back++;
        }
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removedElement = queue[front];
        queue[front] = null;
        front++;
        if (isEmpty()) {
            front = 0;
            back = 0;
        }
        if (front == queue.length) {
            front = 0;
        }
        return removedElement;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.queue[front];
    }

    @Override
    public int size() {
        if (isNotWrapped()) {
            return back - front;
        } else {
            return back - front + this.queue.length;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(T value) {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T[] copiedQueue = copyQueue(size());
        int lastElementIndex = copiedQueue.length - 1;
        for (int currentElementIndex = 0; currentElementIndex < copiedQueue.length / 2; currentElementIndex++, lastElementIndex--) {
            if (ComparableUtil.getInstance().isEqual(copiedQueue[currentElementIndex], value)
                    || ComparableUtil.getInstance().isEqual(copiedQueue[lastElementIndex], value)) {
                return true;
            }
        }
        return false;
    }

    //== private methods ==
    private void validateCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Queue initialization failure. Negative value={" + capacity + " } was passed to the constructor.");
        }
    }

    private boolean isNotWrapped() {
        return front <= back;
    }

    private boolean isEligibleToResize() {
        return size() == queue.length - 1;
    }

    private void doubleSize() {
        int newCapacity = (queue.length == 0) ? DEFAULT_CAPACITY : queue.length * 2;
        queue = copyQueue(newCapacity);
        front = 0;
        back = size();
    }

    private T[] copyQueue(int copySize) {
        T[] copy = (T[]) new Comparable[copySize];
        if (isNotWrapped()) {
            System.arraycopy(queue, front, copy, 0, size());
        } else {
            System.arraycopy(queue, front, copy, 0, queue.length - front);
            System.arraycopy(queue, 0, copy, queue.length - front, back);
        }
        return copy;
    }

}