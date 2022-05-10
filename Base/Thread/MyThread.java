package Base.Thread;

import java.util.concurrent.TimeUnit;

public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        for (int i = 1; i <= 1; i++) {
            Thread thread = new Thread(new PrintWord(200 * i), "我的线程" + i);
            thread.start();
            Thread.sleep(TimeUnit.SECONDS.toMillis(2));
            thread.interrupt();
        }

        System.out.println(Thread.currentThread().getName() + "已结束");
    }

    static class PrintWord implements Runnable {
        int time;
        public static final String WORD = "Hello, this is the king for the world, i will change the world in the future";

        public PrintWord(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 线程开始运行");
            slowPrint();
            System.out.println(Thread.currentThread().getName() + " 线程结束运行");
            TimeUnit.SECONDS.toMillis(1);
        }

        public void slowPrint() {
            for (char c : WORD.toCharArray()) {
                try {
                    Thread.sleep(time);
                    System.out.print(c);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
