package Base.ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);

        es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            };
        });
    }
}
