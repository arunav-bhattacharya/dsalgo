package com.arunav.dsalgo.stack;

/* IMP - The pointer is moving to maintain the top of the stack. Elements in the array are not moved */
public class Stack<T> {

    private int maxSize;
    private int top;
    private T[] stackArray;

    Stack(int size) {
        this.maxSize = size;
        this.top = -1;
        this.stackArray = (T[]) new Object[maxSize];
    }

    public void push(T value) {
        if (!isFull()) {
            this.top++;
            this.stackArray[top] = value;
        } else
            System.out.println("Stack is Full, can't push anymore data !");
    }

    public T pop() {
        if (!isEmpty()) {
            int oldTop = top;
            top--;
            return this.stackArray[oldTop];
        } else {
            System.out.println("Stack is Empty, nothing to pop");
            throw new RuntimeException();
        }
    }

    public T peek() {
        return this.stackArray[this.top];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.top == maxSize - 1);
    }
}
