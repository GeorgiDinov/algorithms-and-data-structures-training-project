package com.georgidinov.datastructures.node.impl;

import com.georgidinov.datastructures.node.BSTNode;
import com.georgidinov.datastructures.node.DoubleLinkedListNode;
import com.georgidinov.datastructures.node.SingleLinkedListNode;

public class Node<T extends Comparable<T>> implements SingleLinkedListNode<T>, DoubleLinkedListNode<T>, BSTNode<T> {


    //== fields ==
    private T value;
    private Node<T> left;
    private Node<T> right;


    //== constructors ==
    public Node() {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }


    //== List Implementations Related Methods ==
    @Override
    public void setNext(SingleLinkedListNode<T> next) {
        right = (Node<T>) next;
    }

    @Override
    public void setNext(DoubleLinkedListNode<T> next) {
        right = (Node<T>) next;
    }

    @Override
    public Node<T> getNext() {
        return right;
    }

    @Override
    public void setPrevious(DoubleLinkedListNode<T> previous) {
        left = (Node<T>) previous;
    }

    @Override
    public DoubleLinkedListNode<T> getPrevious() {
        return left;
    }

    //== methods for Binary Search Tree Implementation ==
    public void setLeft(BSTNode<T> left) {
        this.left = (Node<T>) left;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setRight(BSTNode<T> right) {
        this.right = (Node<T>) right;
    }

    public Node<T> getRight() {
        return right;
    }


    //== Common For All Implementations ==
    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }


    //== for quick testing only
    public static void main(String[] args) {
        SingleLinkedListNode<Integer> node = new Node<>(20);
        SingleLinkedListNode<Integer> secondNode = new Node<>(30);
        node.setNext(secondNode);
        while (node != null) {
            System.out.println(node);
            node = node.getNext();
        }
        BSTNode<Integer> bstNode = new Node<>(5);
        bstNode.insert(2);
        bstNode.insert(8);
        bstNode.insert(6);
        bstNode.insert(12);
        bstNode.insert(1);
        bstNode.insert(3);
        System.out.println("\t\t\t" + bstNode);
        System.out.println("\t\t" + bstNode.getLeft() + "\t\t" + bstNode.getRight());
        System.out.println("\t" + bstNode.getLeft().getLeft() + "\t\t" + bstNode.getLeft().getRight() + "|" + bstNode.getRight().getLeft() + "\t\t" + bstNode.getRight().getRight());
        System.out.print("Traverse in order: ");
        bstNode.traverseInOrder();
        System.out.println();
        System.out.print("Traverse Pre order: ");
        bstNode.traversePreOrder();
        System.out.println();
        System.out.print("Traverse Post order: ");
        bstNode.traversePostOrder();
        System.out.println();
        System.out.println("Min: " + bstNode.min());
        System.out.println("Max: " + bstNode.max());

        System.out.println("Get 25: " + bstNode.get(25));
        System.out.println("Get 12: " + bstNode.get(12));
    }

}