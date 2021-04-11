package com.hy.learn.base.algorithm;

/**
 * @author home-pc
 * @program: java-learn
 * @description: 手写队列，使用数组实现
 * @date 2021-04-11 13:38:27
 */
public class MyQueueByLink {

    class Node {
        private Object data;
        private Node next;
    }

    private int count;

    private int capacity;

    private Node head;

    private Node tail;

    //表示当前队列
    private Node queue;

    public MyQueueByLink(int capacity) {
        Node node = new Node();
        head = node;
        tail = node;
        queue = node;
        for (int i = 0; i < capacity - 1; i++){
            node.next = new Node();
        }
        this.capacity = capacity;
        this.count = 0;
    }

    public boolean enqueue(Object item) {
        //尾部已无下一个节点
        if (tail.next == null){
            if (count == capacity){
                return false;
            }
            //由于我定义的这个队列里固定了长度不允许无限长度的队列，所以做了一位操作
            //将head直接赋值为队列
            queue = head;
            //补充完整长度的队列
            for (int i = 0; i< capacity - count; i++){
                tail.next = new Node();
            }
        }
        tail.data = item;
        count++;
        tail = tail.next;
        return true;
    }

    public Object dequeue() {
        if (count == 0){
            return null;
        }
        Object result = head.data;
        head = head.next;
        count--;
        return result;
    }

    private void printAll(){
        Node temp = queue;
        for (int i = 0; i < count; i++) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyQueueByLink myQueue = new MyQueueByLink(3);
        myQueue.enqueue("111");
        myQueue.enqueue("222");
        myQueue.enqueue("333");
        myQueue.enqueue("444");
        myQueue.enqueue("555");

        myQueue.printAll();

        myQueue.dequeue();
        myQueue.dequeue();

        myQueue.printAll();

        myQueue.enqueue("666");
        myQueue.enqueue("777");
        myQueue.enqueue("888");

        myQueue.printAll();
    }

}
