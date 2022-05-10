package Base.Thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadJoin {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "开始工作");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + "工作结束");
            }, "线程" + i);

            threads.add(thread);
        }

        threads.forEach(item -> {
            try {
                System.out.println("主线程开始join" + item.getName());
                item.join();
                System.out.println("主线程join" + item.getName() + "结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threads.forEach(Thread::start);
    }
}
