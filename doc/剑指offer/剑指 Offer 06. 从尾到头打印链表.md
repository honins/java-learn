# 题目

```
    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    
    示例 1：
    
    输入：head = [1,3,2]
    输出：[2,3,1]
    
    限制：
    
    0 <= 链表长度 <= 10000
```

# 思路

1. 遍历链表，计算该返回的数组的长度 count

2. 新建一个 count长度的数组，遍历链表，从数组的count-1的位置开始插入值

# 解题

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
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
}
```

# 我的问题

虽然思路很快就想到了，但是我中途一直卡在了一个地方，就是我第二次遍历的时候还是需要一个原始的链表
可是第一次遍历链表时经过代码` head = head.next;`后，head已经到表尾了
很明显我在开始就应该要把head存起来，可是怎么存呢？

我刚开始以为`ListNode listNode = head;`是不行的，因为我认为listNode和head地址是一样的，head到了最后一个元素，listNode也会
难道要copy对象吗？

经过一番思索后，觉得copy实在不妥
于是，看了下别人的解答
发现别人就是用的`ListNode listNode = head;`
然后我试了下，发现listNode 居然还是原始对象。
看来是我弄错了

