package com.hy.learn.base.offer;

import java.util.ArrayList;

/**
 * @author home-pc
 * @program: java-learn
 * @description:
 * @date 2021-04-11 20:51:43
 */
public class Num08 {

    static class CQueue {

        private ArrayList<Integer> stack;

        private int stackBottom;

        private int stackTop;

        private ArrayList<Integer> reverseStack;

        public CQueue() {
            stack = new ArrayList<Integer>();
            stackBottom = 0;
            stackTop = 0;

            reverseStack = new ArrayList<Integer>();
        }

        public void appendTail(int value) {
            stack.add(value);
            stackTop++;

            if (stackTop == 1){
                reverseStack = stack;
            }
            for (int i = stackTop - 1; i< stackBottom; i--){
                reverseStack.add(stack.get(i));
            }
        }

        public int deleteHead() {
            if (stackTop == stackBottom){
                return -1;
            }
            Integer head = reverseStack.get(stackBottom);
            if (head == null){
                return -1;
            }
            stackBottom ++;
            return head;
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }


}
