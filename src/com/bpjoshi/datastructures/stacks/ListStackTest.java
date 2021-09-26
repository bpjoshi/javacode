package com.bpjoshi.datastructures.stacks;

public class ListStackTest {
    public static void main(String[] args) {
        Stack<String> stack= new ListStack<>();
        stack.push("Hello");
        System.out.println(stack.size());
        System.out.println(stack.contains("Hello"));
        stack.pop();
        System.out.println(stack.contains("Hello"));
        System.out.println(stack.size());
    }
}
