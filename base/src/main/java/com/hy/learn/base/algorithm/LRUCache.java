package com.hy.learn.base.algorithm;

/**
 * @program: java-learn
 * @description: LRU缓存机制算法 leetcode 146
 * @author: hy
 * @create: 2021-06-02 19:33
 **/
public class LRUCache {

    private Link link;

    private int capacity;

    private int count;


    Node getTailNode() {
        Node node = link.node;
        for (int i = 1; i <= count; i++) {
            if (node.next == null) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    Node getPreNode(Node data){
        Node node = link.node;
        while (node.next != null){
            if (node.next.key == data.key){
                return node;
            }
        }
        return null;
    }

    Node getHeadNode() {
        return link.node;
    }

    class Link {
        Node node;
        Node next;

        public Link(Node node) {
            this.node = node;
        }

        public Link() {

        }

        public void setNode(Node node) {
            this.node = node;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }


    public LRUCache(int capacity) {
        this.link = new Link();
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = -1;

        Node node = link.node;
        if (count > 0) {
            for (int i = 1; i <= count; i++) {
                if (node.key == key) {
                    value = node.value;

                    //删除节点
                    deleteNode(node);

                    //将节点存到链表头
                    insertNodeAtHead(node);
                }
                node = node.next;
            }
        }

        return value;
    }

    private void insertNodeAtHead(Node node) {
        node.next = link.node.next;
        link.node = node;
    }

    private void deleteNode(Node node) {
        Node preNode = getPreNode(node);
        preNode.next = preNode.next.next;
        count --;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value, null);
        if (link.node == null){
            link.setNode(node);
            count++;
        } else if (count < capacity) {
            link.setNext(node);
            count++;
        }

        if (count >= capacity){
            link.node = link.node.next;
            Node tail = getTailNode();
            tail.next = node;
        }

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(111, 111);
        lruCache.get(111);
    }
}
