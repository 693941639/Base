package Base.Concurrent;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicLongTest t = new AtomicLongTest();

        ArrayList<Thread> tArr = new ArrayList<>();
        long loopCount = Integer.MAX_VALUE / 10;

        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                loopCount = Integer.MAX_VALUE - loopCount * 9;
            }
            long finalLoopCount = loopCount;
            Thread thread = new Thread(() -> {
                for (int j = 0; j < finalLoopCount; j++) {
                    t.aLong.getAndIncrement();
                }
            });

            thread.start();
            tArr.add(thread);
        }

        long finalLoopCount1 = loopCount;
        Thread sT = new Thread(() -> {
            for (int i = 0; i < finalLoopCount1; i++) {
                t.b++;
            }
        });

        sT.start();

        sT.join();

        tArr.forEach((item) -> {
            try {
                item.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(t.toString());
    }
    private AtomicLong aLong;

    private volatile long b;

    public AtomicLongTest() {
        this.aLong = new AtomicLong();
    }

    public String toString() {
        return "aLong :" + aLong + ", b:" + b;
    }
}
