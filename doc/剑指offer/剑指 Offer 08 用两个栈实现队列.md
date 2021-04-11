# 题目
```
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
提示：

1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

# 思路

看到这个题目的时候感到很疑惑，疑惑2点
疑问1. 题意是什么？
>["CQueue","appendTail","deleteHead","deleteHead"]
 [[],[3],[],[]]
 输出：[null,null,3,-1]

指的是：
1. CQueue -> 新建对象，
2. appendTail-> 调用appendTail方法入参3
3. deleteHead 调用deleteHead方法返回3
3. deleteHead 调用deleteHead方法返回-1

就是用栈实现队列，appendTail是入栈，deleteHead是出栈

疑问2. 用什么队列？
是用java本身提供的Stack对象吗，还是自己手写一个Stack内部类？
如果用java本身提供的Stack对象，肯定耗时耗空间。

后来决定自己用ArrayList作为Stack，毕竟栈底层也就是数组或链表。

具体解法是
新建2个队列 stack reverseStack;
reverseStack存stack反转后的值，就是先进先出的结果了
# 解题

```java

class Solution {
               
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

```

我提交了2次分别显示

>执行结果：通过
显示详情
执行用时：61 ms, 在所有 Java 提交中击败了43.21%的用户
内存消耗：46.6 MB, 在所有 Java 提交中击败了72.23%的用户


>执行结果：通过
 显示详情
 执行用时：51 ms, 在所有 Java 提交中击败了99.01%的用户
 内存消耗：47.2 MB, 在所有 Java 提交中击败了25.37%的用户

这就很神气了。
具体击败多少，我也不深究了
我也不期望双100

不过学习了栈和队列的基础知识后，这题做起来挺顺利的。有思路了十几分钟代码就写完了。然后花了10分钟调试边界值。