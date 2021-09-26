package com.bpjoshi.datastructures.stacks;

/**
 * Basic Stack Implementation
 * @author Bhagwati Prasad
 */
public class BasicStack<T> implements Stack<T> {
    private T[] data;
    private int stackPointer;

    /**
     * Initialize the array that holds values of stack to 1000
     * Initialize stackPointer to 0, i.e. currently the stack has 0 items
     */
    public BasicStack(){
        data= (T[])new Object[1000];
        stackPointer=0;
    }

    /**
     * Adds a new value of type T to the end of the stack
     * Increments the count of stackPointer by 1
     * @param newItem of type T
     */
    @Override
    public void push(T newItem){
        if(stackPointer==data.length){
            throw new IllegalStateException(this.getClass().getSimpleName()+" is full");
        }
        data[stackPointer++]=newItem;
    }

    /**
     * Return the last item entered on the stack and decrease stackPointer by 1
     * To get the last item, it's available at index stackPointer-1
     * @return the topmost item on the stack
     */
    @Override
    public T pop(){
        if(stackPointer==0){
            throw new IllegalStateException(this.getClass().getSimpleName()+" is Empty");
        }
        return data[--stackPointer];
    }

    /**
     * Searches from the top of the stack till the bottom for the presence of Item
     * @param item of type T to be searched
     * @return true if the item is available in the stack
     */
    @Override
    public boolean contains(T item){
        boolean itemFound=false;
        for(int i=stackPointer-1; i>=0; i--){
            if(data[i].equals(item)){
                itemFound=true;
                break;
            }
        }
        return itemFound;
    }

    /**
     * keeps popping up the element, until the item is found or the stack is empty.
     * @param item of type T
     * @return the item if it's available in the stack, else throws IllegalArgumentException
     */
    @Override
    public T access(T item){
        while(stackPointer>0){
            T pop = pop();
            if(pop.equals(item)){
                return pop;
            }
        }
        throw new IllegalArgumentException(item+" is not available in the "+this.getClass().getSimpleName());
    }

    /**
     * @return stackPointer i.e. number of items in the stack
     */
    @Override
    public int size(){
        return stackPointer;
    }

}

