package com.hy.learn.base.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * @author home-pc
 * @program: java-learn
 * @description:
 * @date 2021-03-20 11:33:09
 */
public class Num06 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static int[] reversePrint(ListNode head) {

        if (head == null){
            return new int[0];
        }
        ListNode listNode = head;

        int count = 1;

        while (head.next != null){
            count++;
            head = head.next;
        }

        int[] reverseListNode = new int[count];
        for (int i = count-1; i >= 0; i--) {
            reverseListNode[i] = listNode.val;
            listNode = listNode.next;
        }

        return reverseListNode;
    }

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);

        listNode0.next = listNode1;
        listNode1.next = listNode2;
        int[] ints = reversePrint(listNode0);
        System.out.println(Arrays.toString(ints));
    }

}
