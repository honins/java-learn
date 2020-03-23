import com.hy.learn.base.concurrent.MyCallable;
import com.hy.learn.base.concurrent.MyRunnable;
import com.hy.learn.base.concurrent.MyThread;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Created by hy
 * @date on 2020/2/28 16:35
 */
public class ConcurrentTest {

    @Test
    public void test1(){
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }

    /**
     * 实现接口 VS 继承 Thread
     * 实现接口会更好一些，因为：
     *
     * Java 不支持多重继承，因此继承了 Thread 类就无法继承其它类，但是可以实现多个接口；
     * 类可能只要求可执行就行，继承整个 Thread 类开销过大。
     */
    @Test
    public void test3() {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    @Test
    public void test4() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }

}
