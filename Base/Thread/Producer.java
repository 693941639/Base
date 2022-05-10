package Base.Thread;

import java.util.Queue;

public class Producer<T> {

    private final Queue<T> tasks;

    private int maxCount = 0;

    public Producer(Queue<T> tasks, int maxCount) {
        this.tasks = tasks;
        this.maxCount = maxCount;
    }

    public void produce(T task) throws InterruptedException {
        synchronized (tasks) {
            while (tasks.size() >= maxCount) {
                System.out.println("队列消息已达上线");
                tasks.wait();
            }

            tasks.add(task);

            tasks.notifyAll();
        }
    }
}
