package com.hy.learn.base.algorithm;

/**
 * @author home-pc
 * @program: java-learn
 * @description: 手写队列，使用数组实现
 * @date 2021-04-11 13:38:27
 */
public class MyQueueByList {

    private Object[] items;

    private int capacity;

    private int head = 0;

    private int tail = 0;

    public MyQueueByList(int capacity) {
        this.items = new Object[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(Object item) {
        if (tail == capacity) {
            //队列已占满
            if (head == 0) {
                return false;
            }
//            //移动队列
//            int newTail = 0;
//            int temp = head;
//            for (int i = 0; temp < tail; i++) {
//                items[i] = items[temp];
//                temp++;
//                newTail = i + 1;
//            }
//            tail = newTail;
//            head = 0;
//            items[tail] = item;
//            tail++;
            //tail已到数组尾部，移动队列
            //比注释部分实现更加优雅
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        tail++;
        return true;
    }

    public Object dequeue() {
        if (head == tail) {
            return null;
        }
        return items[head++];
    }

    public static void main(String[] args) {
        MyQueueByList myQueueByList = new MyQueueByList(3);
        myQueueByList.enqueue("111");
        myQueueByList.enqueue("222");
        myQueueByList.enqueue("333");
        myQueueByList.enqueue("444");
        myQueueByList.enqueue("555");
        myQueueByList.dequeue();
        myQueueByList.dequeue();
        myQueueByList.enqueue("666");
        myQueueByList.enqueue("777");
    }

}
