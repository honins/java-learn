package com.hy.learn.base.algorithm;

/**
 * @author home-pc
 * @program: java-learn
 * @description: 手写循环队列，使用数组实现
 * @date 2021-04-11 13:38:27
 */
public class MyCircularByList {

    private Object[] items;

    private int capacity;

    private int head = 0;

    private int tail = 0;

    public MyCircularByList(int capacity) {
        //循环队列因为队列空判断条件，会浪费一个数组空间
        capacity = capacity + 1;
        this.items = new Object[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(Object item) {
        //队列已占满
        if ((tail + 1) % capacity == head) {
            return false;
        }

        items[tail] = item;
        tail = (++tail) % capacity;
        return true;
    }

    public Object dequeue() {
        //队列为空
        if (head == tail) {
            return null;
        }
        Object result = items[head];
        head = (++head) % capacity;
        return result;
    }

    public void printAll(){
        int temp = head;
        while (temp != tail){
            System.out.println(items[temp]);
            temp = (++temp) % capacity;
        }
    }

    public static void main(String[] args) {
        MyCircularByList myQueueByList = new MyCircularByList(3);
        myQueueByList.enqueue("111");
        myQueueByList.enqueue("222");
        myQueueByList.enqueue("333");
        myQueueByList.enqueue("444");
        myQueueByList.enqueue("555");
        myQueueByList.printAll();
        System.out.println("#######");

        myQueueByList.dequeue();
        myQueueByList.dequeue();
        myQueueByList.printAll();
        System.out.println("#######");

        myQueueByList.enqueue("666");
        myQueueByList.enqueue("777");
        myQueueByList.enqueue("888");
        myQueueByList.printAll();
    }

}
