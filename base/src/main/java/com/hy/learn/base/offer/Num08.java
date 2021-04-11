package com.hy.learn.base.offer;

import java.util.LinkedList;

/**
 * @author home-pc
 * @program: java-learn
 * @description:
 * @date 2021-04-11 20:51:43
 */
public class Num08 {

    static class CQueue {

        private LinkedList<Integer> stack;

        private LinkedList<Integer> reverseStack;

        public CQueue() {
            stack = new LinkedList<>();
            reverseStack = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack.push(value);
        }

        public int deleteHead() {
            if (reverseStack.isEmpty()) {
                if (stack.isEmpty()) {
                    return -1;
                }

                while (!stack.isEmpty()) {
                    reverseStack.push(stack.pop());
                }
                return reverseStack.pop();
            }
            return reverseStack.pop();
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(4);
        System.out.println(cQueue.deleteHead());
    }


}
