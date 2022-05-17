package Base.Thread;

import java.util.concurrent.TimeUnit;

public class InterrruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int i  = 1;
            while (true) {
//                try {
//                    Thread.sleep(TimeUnit.SECONDS.toMillis(1));
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println(i++);
            }
        });

        t1.start();

        Thread.sleep(TimeUnit.SECONDS.toMillis(5));

        t1.interrupt();

        System.out.println("Main thread finish");
    }
}
