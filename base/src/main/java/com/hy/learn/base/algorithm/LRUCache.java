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

    class Link {
        Node node;
        Node next;

        public Link(Node node) {
            this.node = node;
        }

        Node getHeadNode() {
            return link.node;
        }

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
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = -1;

        Node node = link.node;
        if (count > 0) {
            for (int i = 1; i <= count; i++) {
                if (node.key == key) {
                    value = node.value;
                }
                node = node.next;
            }
        }

        return value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value, null);
        if (count < capacity) {
            link.next = node;
            count++;
        }

        link.node = link.node.next;
        Node tail = link.getTailNode();
        tail.next = node;
    }

}
