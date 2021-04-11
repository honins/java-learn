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

# 符合题意的做法

## 思路
上一个做法完成后，再看了一遍题目，感觉上面做法并不符合题意，上面做法实例上没有使用栈，就是单纯的数组操作。

看了一下别人的解答发现

>使用java的同学请注意，如果你使用Stack的方式来做这道题，会造成速度较慢； 原因的话是Stack继承了Vector接口，而Vector底层是一个Object[]数组，那么就要考虑空间扩容和移位的问题了。 
>可以使用LinkedList来做Stack的容器，因为LinkedList实现了Deque接口，所以Stack能做的事LinkedList都能做，其本身结构是个双向链表，扩容消耗少。 但是我的意思不是像100%代码那样直接使用一个LinkedList当做队列，那确实是快，但是不符题意。 贴上代码，这样的优化之后，效率提高了40%，超过97%。

看来可以使用LinkedList来做Stack的容器
也是做了一个符合题意的解法，还花了些时间

## 解法
```java

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

```

需要注意的是
1. 我刚开始尝试在appendTail填充反转Stack。后来发现这个做法不对，不能解决 push1 push2 pop1 push3 pop2的情形，第二次pop2应该输出push2。若每次push就填充则返回的是push3
2. deleteHead方法中，首先要全部输出完reverseStack，再往reverseStack中填充，否则也会出现1的错误情况

结果
>执行结果：通过
 显示详情
 执行用时：55 ms, 在所有 Java 提交中击败了87.93%的用户
 内存消耗：46.7 MB, 在所有 Java 提交中击败了49.56%的用户