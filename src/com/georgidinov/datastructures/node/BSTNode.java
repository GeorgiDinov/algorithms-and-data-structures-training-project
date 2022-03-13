package com.georgidinov.datastructures.node;

import com.georgidinov.datastructures.node.impl.Node;

/**
 * @param <T> every object that implements the Comparable interface
 *            <p>
 *            This interface defines common behaviour of a node in a Binary Search Tree.
 *            </p>
 *            <p>
 *            Binary Search Tree is a tree consisting only of three nodes: parent, left child and right child
 *            </p>
 *            <p>***(parent) </p>
 *            <p>****** /  \   </p>
 *            <p>**(left)  (right)    </p>
 */
public interface BSTNode<T extends Comparable<T>> extends NodeValue<T> {

    //== abstract methods ==
    void setLeft(BSTNode<T> left);

    BSTNode<T> getLeft();

    void setRight(BSTNode<T> right);

    BSTNode<T> getRight();


    //== default methods ==

    /**
     * @param value the value to be inserted in the Binary Search Tree.
     *              <p>
     *              Based on the {@link java.lang.Comparable#compareTo(Object)} result:
     *              </p>
     *              <p>
     *              If the passed value is equal to the one in the current tree node it won't be added.
     *              </p>
     *              <p>
     *              If the value is after the value of the current tree node it will invoke {@link #insert(Comparable)} to the right child if
     *              present, otherwise it will initialize new right child with the passed value.
     *              </p>
     *              <p>
     *              If the value is before the value of the current tree node it will invoke {@link #insert(Comparable)} to the left child if
     *              present, otherwise it will initialize new left child with the passed value.
     *              </p>
     */
    default void insert(T value) {
        int comparableResult = this.getValue().compareTo(value);
        if (comparableResult == 0) {
            return;
        }
        if (comparableResult < 0) {
            if (this.getRight() == null) {
                this.setRight(new Node<>(value));
            } else {
                this.getRight().insert(value);
            }
        } else {
            if (this.getLeft() == null) {
                this.setLeft(new Node<>(value));
            } else {
                this.getLeft().insert(value);
            }
        }
    }

    /**
     * @param value The value to search for in the BST
     * @return <p>{@link com.georgidinov.datastructures.node.BSTNode} holding the value or</p>
     * <p>null if the value is not present in the BST</p>
     */
    default BSTNode<T> get(T value) {
        int comparableResult = this.getValue().compareTo(value);
        if (comparableResult == 0) {
            return this;
        }
        if (comparableResult < 0) {
            if (this.getRight() != null) {
                return this.getRight().get(value);
            }
        } else {
            if (this.getLeft() != null) {
                return this.getLeft().get(value);
            }
        }
        return null;
    }

    /**
     * @return The leftmost tree node value. Which represents the min value in the BST
     */
    default T min() {
        return this.getLeft() != null ? this.getLeft().min() : this.getValue();
    }

    /**
     * @return The rightmost tree node value. Which represents the max value in the BST
     */
    default T max() {
        return this.getRight() != null ? this.getRight().max() : this.getValue();
    }


    /**
     * Prints the elements of the BST in order.
     * Left child, parent, right child.
     */
    default void traverseInOrder() {
        if (this.getLeft() != null) {
            this.getLeft().traverseInOrder();
        }
        System.out.print(this + " ");
        if (this.getRight() != null) {
            this.getRight().traverseInOrder();
        }
    }

    /**
     * Prints the elements of the BST in pre order.
     * Parent, left child, right child.
     */
    default void traversePreOrder() {
        System.out.print(this + " ");
        if (this.getLeft() != null) {
            this.getLeft().traversePreOrder();
        }
        if (this.getRight() != null) {
            this.getRight().traversePreOrder();
        }
    }

    /**
     * Prints the elements of the BST in post order.
     * Left child, right child, parent.
     */
    default void traversePostOrder() {
        if (this.getLeft() != null) {
            this.getLeft().traversePostOrder();
        }
        if (this.getRight() != null) {
            this.getRight().traversePostOrder();
        }
        System.out.print(this + " ");
    }

}