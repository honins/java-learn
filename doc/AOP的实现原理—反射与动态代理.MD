# AOP的实现原理—反射与动态代理
[AOP的实现原理—反射与动态代理](https://blog.csdn.net/fuzhongmin05/article/details/61615149)

写的挺好，挺有用

其实AOP的意思就是面向切面编程。OO注重的是我们解决问题的方法(封装成Method)，而AOP注重的是解决许多问题的方法中的共同点，是对OO思想的一种补充！还是拿人家经常举的一个例子讲解一下吧：比如说，我们现在要开发的一个应用里面有很多的业务方法，但是，我们现在要对这个方法的执行做全面监控,或部分监控。也许我们就会在要一些方法前去加上一条日志记录，我们写个例子看看我们最简单的解决方案。

```java
public interface IHello {
     /**
      * 假设这是一个业务方法
      * @param name
      */
     void sayHello(String name);
}
```

        里面有一个方法，用于输入"Hello"加传进来的姓名。我们去写个类实现IHello接口：

```java
public class Hello implements IHello {
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
```
        现在我们要为这个业务方法加上日志记录的业务，在不改变源代码的情况下，我们会去怎么做呢?也许，你会去写一个类去实现IHello接口，并依赖Hello这个类。代码如下：
```
public class HelloProxy implements IHello {
     private IHello hello;
     public HelloProxy(IHello hello) {
         this.hello = hello;
     }
     public void sayHello(String name) {
        Logger.logging(Level.DEBUGE, "sayHello method start.");
        hello.sayHello(name);
        Logger.logging(Level.INFO, "sayHello method end!");
     }
}
```
        其中Logger类代码如下:
```
public class Logger{
    /**
     * 根据等级记录日志
     * @param level
     * @param context
     */
    public static void logging(Level level, String context) {
        if (level.equals(Level.INFO)) {
            System.out.println(new Date().toLocaleString() + " " + context);
        }
        if (level.equals(Level.DEBUGE)) {
            System.err.println(new Date() + " " + context);
        }
    }
}
```
        Level枚举代码如下:
```
public enum Level {
    INFO,DEBUGE;
}
```
        现在我们去写个测试类看看，代码如下：
```java
public class Test {
    public static void main(String[] args) {
        IHello hello = new HelloProxy(new Hello());
        hello.sayHello("Doublej");
    }
}
```

        运行以上代码我们可以得到下面结果：

Tue Mar 04 20:57:12 CST 2008 sayHello method start.
Hello Doublej
2008-3-4 20:57:12 sayHello method end!
        从上面的代码我们可以看出，hello对象是被HelloProxy这个所谓的代理类所创建的。这样，如果我们以后要把日志记录的功能去掉。那我们只要把得到hello对象的代码改成以下：

```java
public class Test {
    public static void main(String[] args) {
        IHello hello = new Hello();
        hello.sayHello("Doublej");
    }
}

```

        上面的代码，可以说是AOP最简单的实现！

        但是我们会发现一个问题，如果我们像Hello这样的类很多，那么，我们是不是要去写很多个HelloProxy这样的类呢？没错，是的。其实也是一种很麻烦的事。在jdk1.3以后，jdk跟我们提供了一个API,即java.lang.reflect.InvocationHandler的类。 这个类可以让我们在JVM调用某个类的方法时动态的为些方法做些什么事，让我们把以上的代码改一下来看看效果。同样，我们写一个IHello的接口和一个Hello的实现类。在接口中，我们定义两个方法；代码如下 ：
```java

public interface IHello {
    /**
     * 业务处理A方法
     * @param name
     */
    void sayHello(String name);
    /**
     * 业务处理B方法
     * @param name
     */
    void sayGoogBye(String name);
}
```

        Hello.java代码如下：
```java

public class Hello implements IHello {
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
    public void sayGoogBye(String name) {
        System.out.println(name+" GoodBye!");
    }
}
```

        我们一样的去写一个代理类。只不过，让这个类去实现java.lang.reflect.InvocationHandler接口，代码如下：
```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class DynaProxyHello implements InvocationHandler {
    /**
     * 要处理的对象(也就是我们要在方法的前后加上业务逻辑的对象,如例子中的Hello)
     */
    private Object delegate;
    /**
     * 动态生成方法被处理过后的对象 (写法固定)
     * 
     * @param delegate
     * @param proxy
     * @return
     */
    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(
                this.delegate.getClass().getClassLoader(), this.delegate
                        .getClass().getInterfaces(), this);
    }
    /**
     * 要处理的对象中的每个方法会被此方法送去JVM调用,也就是说,要处理的对象的方法只能通过此方法调用
     * 此方法是动态的,不是手动调用的
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            //执行原来的方法之前记录日志
            Logger.logging(Level.DEBUGE, method.getName() + " Method end .");
            
            //JVM通过这条语句执行原来的方法(反射机制)
            result = method.invoke(this.delegate, args);
            //执行原来的方法之后记录日志
            Logger.logging(Level.INFO, method.getName() + " Method Start!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回方法返回值给调用者
        return result;
    }
}

```

        上面类中出现的Logger类和Level枚举还是和上一上例子的实现是一样的，这里就不贴出代码了。
```java

public class Test {
    public static void main(String[] args) {
        IHello hello = (IHello)new DynaProxyHello().bind(new Hello());
        hello.sayGoogBye("Double J");
        hello.sayHello("Double J");
    }
}
```

        运行输出的结果如下：

Tue Mar 04 21:24:03 CST 2008 sayGoogBye Method end .
Double J GoodBye!
2008-3-4 21:24:03 sayGoogBye Method Start!
Tue Mar 04 21:24:03 CST 2008 sayHello Method end .
Hello Double J
2008-3-4 21:24:03 sayHello Method Start!
        由于线程的关系，第二个方法的开始出现在第一个方法的结束之前。这不是我们所关注的!从上面的例子我们看出，只要你是采用面向接口编程，那么，你的任何对象的方法执行之前要加上记录日志的操作都是可以的。他(DynaPoxyHello)自动去代理执行被代理对象(Hello)中的每一个方法，一个java.lang.reflect.InvocationHandler接口就把我们的代理对象和被代理对象解藕了。但是，我们又发现还有一个问题，这个DynaPoxyHello对象只能跟我们去在方法前后加上日志记录的操作。我们能不能把DynaPoxyHello对象和日志操作对象(Logger)解藕呢?

        结果是肯定的，让我们来分析一下我们的需求。我们要在被代理对象的方法前面或者后面去加上日志操作代码(或者是其它操作的代码)，那么，我们可以抽象出一个接口，这个接口里就只有两个方法，一个是在被代理对象要执行方法之前执行的方法，我们取名为start，第二个方法就是在被代理对象执行方法之后执行的方法，我们取名为end 。接口定义如下 ：

```java

public interface IOperation {
    /**
     * 方法执行之前的操作
     * @param method
     */
    void start(Method method);
    /**
     * 方法执行之后的操作
     * @param method
     */
    void end(Method method);
}
```

        我们去写一个实现上面接口的类，我们把它作为真正的操作者，如下面是日志操作者类，它实现了上面的接口：
```java

public class LoggerOperation implements IOperation {
    public void end(Method method) {
        Logger.logging(Level.DEBUGE, method.getName() + " Method end .");
    }
    public void start(Method method) {
        Logger.logging(Level.INFO, method.getName() + " Method Start!");
    }
}

```

        然后我们要改一下代理对象DynaProxyHello中的代码，如下：

```java

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class DynaProxyHello implements InvocationHandler {
    /**
     * 操作者
     */
    private Object proxy;
    /**
     * 要处理的对象(也就是我们要在方法的前后加上业务逻辑的对象,如例子中的Hello)
     */
    private Object delegate;
 
 
    /**
     * 动态生成方法被处理过后的对象 (写法固定)
     * 
     * @param delegate
     * @param proxy
     * @return
     */
    public Object bind(Object delegate,Object proxy) {
       
        this.proxy = proxy;
        this.delegate = delegate;
        return Proxy.newProxyInstance(
                this.delegate.getClass().getClassLoader(), this.delegate
                        .getClass().getInterfaces(), this);
    }
    /**
     * 要处理的对象中的每个方法会被此方法送去JVM调用,也就是说,要处理的对象的方法只能通过此方法调用
     * 此方法是动态的,不是手动调用的
    */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
        //反射得到操作者的实例
            Class clazz = this.proxy.getClass();
            //反射得到操作者的Start方法
            Method start = clazz.getDeclaredMethod("start",new Class[] { Method.class });
            //反射执行start方法
            start.invoke(this.proxy, new Object[] { method });
            //执行要处理对象的原本方法
            result = method.invoke(this.delegate, args);
            //反射得到操作者的end方法
            Method end = clazz.getDeclaredMethod("end",new Class[] { Method.class });
            //反射执行end方法
            end.invoke(this.proxy, new Object[] { method });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

```

        然后我们把Test.java中的代码改一下，测试一下：
```java
public class Test {
    public static void main(String[] args) {
        IHello hello = (IHello)new DynaProxyHello().bind(new Hello(),new LoggerOperation());
        hello.sayGoogBye("Double J");
        hello.sayHello("Double J");
        
    }
}

```

         结果还是一样的吧。如果你想在每个方法之前加上日志记录,而不在方法后加上日志记录，你就把LoggerOperation类改成如下：
```java
import java.lang.reflect.Method;
public class LoggerOperation implements IOperation {
    public void end(Method method) {
        //Logger.logging(Level.DEBUGE, method.getName() + " Method end .");
    }
    public void start(Method method) {
        Logger.logging(Level.INFO, method.getName() + " Method Start!");
    }
}

```

        运行一下，你就会发现，每个方法之后没有记录日志了。 这样，我们就把代理者和操作者解藕了！

        如果我们不想让所有方法都被日志记录，我们应该怎么去解藕呢?我的想法是在代理对象的public Object invoke(Object proxy, Method method, Object[] args)方法里面加上个if()，对传进来的method的名字进行判断，判断的条件存在XML里面。这样我们就可以通过配置文件进行解藕了。如果有兴趣的朋友可以把操作者、被代理者都通过配置文件进行配置，那么就可以写一个简单的Spring AOP框架了。