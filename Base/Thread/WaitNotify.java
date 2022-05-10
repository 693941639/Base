package Base.Thread;

import java.util.concurrent.TimeUnit;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "开始工作");

                synchronized (lock) {
                    try {
                        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                        System.out.println(Thread.currentThread().getName() + "进入wait状态");
                        lock.wait();

                        System.out.println(Thread.currentThread().getName() + "继续执行");
                        System.out.println(Thread.currentThread().getName() + "执行结束");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, i + "号线程").start();
        }

        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        synchronized (lock) {
            lock.notifyAll();
        }
        System.out.println("main线程执行结束");
    }
}
