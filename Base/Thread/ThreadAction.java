package Base.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadAction {
    public static void main(String[] args) {
        Object lock = new Object();
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(() -> {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " start exec");
                    ThreadAction ta = new ThreadAction();

                    ta.setActionName("DB action");
                    ta.actioneStart();
                    try {
                        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ta.actionEnd();

                    ta.setActionName("Other action");
                    ta.actioneStart();
                    try {
                        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ta.actionEnd();

                    ta.print();
                    System.out.println(Thread.currentThread().getName() + " end exec");
                }
            }, "Thread " + i);
            t.start();
        }
    }

    private String actionName;

    private static ThreadLocal<Long> START = new ThreadLocal<>();

    private static ThreadLocal<ArrayList<Phase>> PHASES = new ThreadLocal<>();

    public ThreadAction() {
        PHASES.set(new ArrayList<>());
    }

    private static class Phase {
        private String name;
        private long time;

        public Phase(String name, long time) {
            this.name = name;
            this.time = time;
        }

        public String toString() {
            return this.name + "执行了:" + this.time;
        }
    }

    public void setActionName(String name) {
        this.actionName = name;
    }

    public void actioneStart() {
        START.set(System.currentTimeMillis());
    }

    public void actionEnd() {
        PHASES.get().add(new Phase(this.actionName, System.currentTimeMillis() - START.get()));
    }

    public void print() {
        PHASES.get().forEach(item -> {
            System.out.println(item.name + "执行了" + item.time);
        });
    }
}
