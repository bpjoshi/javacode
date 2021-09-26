package com.bpjoshi.datastructures.stacks;

import java.util.ArrayList;

public class ListStack<T> implements Stack<T>{
    private ArrayList<T> data;

    public ListStack(){
        data= new ArrayList<>();
    }

    @Override
    public void push(T newItem) {
        data.add(newItem);
    }

    @Override
    public T pop() {
        if(data.size()==0)
            throw new IllegalStateException(this.getClass().getSimpleName()+" is Empty");
        return data.remove(data.size()-1);
    }

    @Override
    public boolean contains(T item) {
        return data.contains(item);
    }

    @Override
    public T access(T item) {
        while(data.size()>0){
            T pop = pop();
            if(pop.equals(item)){
                return pop;
            }
        }
        throw new IllegalArgumentException("Item not available in "+this.getClass().getSimpleName());
    }

    @Override
    public int size() {
        return data.size();
    }
}
