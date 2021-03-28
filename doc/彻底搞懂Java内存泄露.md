# 彻底搞懂Java内存泄露
链接：https://www.jianshu.com/p/efec4c77e265

Java内存回收方式
Java判断对象是否可以回收使用的而是可达性分析算法。

在主流的商用程序语言中(Java和C#)，都是使用可达性分析算法判断对象是否存活的。这个算法的基本思路就是通过一系列名为"GC Roots"的对象作为起始点，从这些节点开始向下搜索，搜索所走过的路径称为引用链(Reference Chain)，当一个对象到GC Roots没有任何引用链相连时，则证明此对象是不可用的，下图对象object5, object6, object7虽然有互相判断，但它们到GC Roots是不可达的，所以它们将会判定为是可回收对象。
![img](https://upload-images.jianshu.io/upload_images/1281543-e702bd76691eb682.png?imageMogr2/auto-orient/strip|imageView2/2/w/429/format/webp)

在Java语言里，可作为GC Roots对象的包括如下几种：
>
    a.虚拟机栈(栈桢中的本地变量表)中的引用的对象
    b.方法区中的类静态属性引用的对象
    c.方法区中的常量引用的对象
    d.本地方法栈中JNI的引用的对象 
    
摘自《深入理解Java虚拟机》

作者：编程之乐
链接：https://www.jianshu.com/p/efec4c77e265
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
