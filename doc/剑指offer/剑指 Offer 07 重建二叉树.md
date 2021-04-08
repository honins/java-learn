# 题目
```
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 
限制：

0 <= 节点个数 <= 5000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```

# 思路

我必须承让，这题想了几天没有pass，只知道用递归，然后核心是如何获得正确的递归方法入参。
也许是下班后回家，无法完全安静的、专注的思考问题，总是被各种事情打断。
这个问题我已经耗费了几天的时间了，不想再这个问题是继续耗费时间精力了，时间不多了。
这里贴一下别人的解法，后面再回顾这个题的时候，再把这个问题完全想通。


# 解题

```java

class Solution {
  private Map<Integer, Integer> indexMap;

  public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
      if (preorder_left > preorder_right) {
          return null;
      }

      // 前序遍历中的第一个节点就是根节点
      int preorder_root = preorder_left;
      // 在中序遍历中定位根节点
      int inorder_root = indexMap.get(preorder[preorder_root]);

      // 先把根节点建立出来
      TreeNode root = new TreeNode(preorder[preorder_root]);
      // 得到左子树中的节点数目
      int size_left_subtree = inorder_root - inorder_left;
      // 递归地构造左子树，并连接到根节点
      // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
      root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
      // 递归地构造右子树，并连接到根节点
      // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
      root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
      return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
      int n = preorder.length;
      // 构造哈希映射，帮助我们快速定位根节点
      indexMap = new HashMap<Integer, Integer>();
      for (int i = 0; i < n; i++) {
          indexMap.put(inorder[i], i);
      }
      return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
  }
}

```
