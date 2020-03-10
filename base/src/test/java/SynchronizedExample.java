import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Created by hy
 * @date on 2020/2/28 16:35
 */
public class SynchronizedExample {

    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());
        executorService.shutdown();

//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        try {
//            countDownLatch.wait(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
