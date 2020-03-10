/**
 * @author Created by hy
 * @date on 2020/2/28 17:46
 */
public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1:"+threadLocal.get());
            threadLocal.remove();
        });
        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            System.out.println("thread2:"+threadLocal.get());
            threadLocal.remove();
        });
        thread1.start();
        thread2.start();
    }
}

