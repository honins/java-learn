package com.hy.learn.base.algorithm;/**
 * @author Created by hy
 * @date on 2021/6/2 19:33
 */

import java.util.List;

/**
 * @program: java-learn
 *
 * @description: LRU缓存机制算法 leetcode 146
 *
 * @author: hy
 *
 * @create: 2021-06-02 19:33
 **/
public class LRUCache {

    class Node{
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    List<Node> nodes;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        nodes
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        nodes.add(node);
    }

}
