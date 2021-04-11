package com.hy.learn.base.algorithm;

/**
 * @author Created by hy
 * @date on 2021/4/9 16:37
 */
public class MyStack {

    private Object[] items;

    private int size;

    private int point;

    public MyStack() {
        items = new Object[4];
        this.point = 0;
        this.size = 4;
    }

    public boolean push(Object item) {
        if (point >= size) {
            size = size * 2;
            Object[] newItems =  new Object[size];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }

        items[point] = item;
        ++point;
        return true;
    }

    public Object pop() {

        if (point == 0) {
            return null;
        }

        --point;
        Object item = items[point];
        items[point] = null;
        return item;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(111);
        myStack.push(222);
        myStack.push(333);
        myStack.push(444);
        myStack.push(555);
        myStack.push(666);
        myStack.pop();
        myStack.pop();
    }

}
