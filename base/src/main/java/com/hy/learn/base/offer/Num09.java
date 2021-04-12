package com.hy.learn.base.offer;

import java.util.LinkedList;

/**
 * @author home-pc
 * @program: java-learn
 * @description: 两个栈实现队列
 * @date 2021-04-11 20:51:43
 */
public class Num09 {

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

        public int fib(int n) {

            if(n <=1){
                return n;
            }

            int a = 0;
            int b = 1;
            int sum = 0;
            for (int i = 2; i < n; i++) {
                sum = (a + b)%1000000007;
                a = b;
                b = sum;
            }

            return sum;
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
