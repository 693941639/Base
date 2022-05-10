package Base.Thread;

import java.util.Queue;

public class Consumer<T> {
    private final Queue<T> tasks;

    public Consumer(Queue<T> tasks) {
        this.tasks = tasks;
    }

    public T consumer() throws InterruptedException {
        while (true) {
            synchronized (tasks) {
                while (tasks.size() == 0) {
                    System.out.println("消费者进入等待");
                    tasks.wait();
                }

                T task = tasks.poll();

                tasks.notifyAll();
                return task;
            }
        }
    }
}
