package com.mani.soni.stack;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(5);
        customStack.push(20);
        customStack.push(10);
        System.out.println(customStack.getMin());
        customStack.push(5);
        System.out.println(customStack.getMin());
        customStack.pop();
        System.out.println(customStack.getMin());
        customStack.pop();
        System.out.println(customStack.getMin());
    }
}
class CustomStack extends Stack<Integer> {
    private Stack<Integer> minStack;

    public CustomStack(int s) {
        minStack = new Stack<>();
    }

    public Integer getMin() {
        return this.minStack.peek();
    }

    @Override
    public Integer push(Integer item) {
        super.push(item);
        if(this.minStack.isEmpty() || this.minStack.peek() > item) {
            this.minStack.push(item);
        }
        return item;
    }

    @Override
    public synchronized Integer pop() {
        if(!minStack.isEmpty() && minStack.peek() == this.peek()) {
            minStack.pop();
        }
        return super.pop();
    }
}