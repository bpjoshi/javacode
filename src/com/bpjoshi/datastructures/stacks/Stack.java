package com.bpjoshi.datastructures.stacks;

/**
 * @author Bhagwati Prasad 
 * @param <T>
 */
public interface Stack<T> {
    /**
     * Adds a new value of type T to the end of the stack
     * Increments the count of stackPointer by 1
     *
     * @param newItem of type T
     */
    void push(T newItem);

    /**
     * Return the last item entered on the stack and decrease stackPointer by 1
     * To get the last item, it's available at index stackPointer-1
     *
     * @return the topmost item on the stack
     */
    T pop();

    /**
     * Searches from the top of the stack till the bottom for the presence of Item
     *
     * @param item of type T to be searched
     * @return true if the item is available in the stack
     */
    boolean contains(T item);

    /**
     * keeps popping up the element, until the item is found or the stack is empty.
     *
     * @param item of type T
     * @return the item if it's available in the stack, else throws IllegalArgumentException
     */
    T access(T item);

    /**
     * @return stackPointer i.e. number of items in the stack
     */
    int size();
}
