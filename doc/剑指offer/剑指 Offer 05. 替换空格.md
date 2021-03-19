# 题目
```
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 
示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 
限制：

0 <= s 的长度 <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
```
# 思路：
## 1. replace()
在思考这道题时，脑海中总是会出现String.replace()
```
replace(CharSequence target, CharSequence replacement)
```
忍不住看了下评论，果然有很多人说这个方法

## 2. 遍历字符串
先遍历字符串，根据空格数计算新字符串的长度。
然后遍历字符串，添加 `%20`
```java
class Solution {
    public String replaceSpace(String s) {
        
        int count = 0;
        for (int i =0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                count++;
            }
        }

        int length = count * 2 + s.length();
        char[] chars = s.toCharArray();
        char[] newChar = new char[length];

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                newChar[index] = '%';
                newChar[index+1] = '2';
                newChar[index+2] = '0';
                index = index + 3;
            }else {
                newChar[index] = chars[i];
                index ++;
            }
        }

        return new String(newChar);
    }
}
```

难度不大，但是还是要小心这里
```
  newChar[index] = '%';
                newChar[index+1] = '2';
                newChar[index+2] = '0';
                index = index + 3;
```
调试了好几次，不仔细计算下标的话会出现数组越界和结果不符的情况

## 总体感觉这题没多大意义，毕竟大佬们早就写好了API而且随处可用，何必重复造轮子呢
