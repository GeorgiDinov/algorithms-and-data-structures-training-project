package com.georgidinov.datastructures.queue;

import com.georgidinov.datastructures.iterator.Iterator;
import com.georgidinov.datastructures.queue.impl.QueueArrayImpl;

public class QueueMain {

    public static void main(String[] args) {
        Queue<Integer> queue = new QueueArrayImpl<>();
        queue.add(15);
        queue.add(25);
        queue.add(35);
        queue.add(45);
        printQueue(queue);

        System.out.println("Peek=" + queue.peek());
        System.out.println("Remove=" + queue.remove());
        System.out.println("Peek=" + queue.peek());
        printQueue(queue);

    }

    private static void printQueue(Queue queue) {
        Iterator queueIterator = queue.iterator();
        System.out.print("Queue=");
        while (queueIterator.hasNext()) {
            System.out.print(queueIterator.next() + " ");
        }
        System.out.println();
    }

}