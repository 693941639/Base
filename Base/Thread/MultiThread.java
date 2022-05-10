package Base.Thread;

public class MultiThread {
    public static void main(String[] args) {
        DoSomething ds = new DoSomething();
        Thread a = new Thread(new TestMath(2, Integer.MAX_VALUE, ds));
        Thread b = new Thread(new TestMath(-2, Integer.MAX_VALUE, ds));

        System.out.println("执行开始");
        a.start();
        b.start();

        ds.print();

        new Thread(() -> {
            System.out.println("lalala");
        });
    }

    static class TestMath implements Runnable {
        public long a;

        public long time = 0;

        public DoSomething ds;

        public TestMath(long num, long num2, DoSomething obj) {
            this.a = num;
            this.time = num2;
            this.ds = obj;
        }

        @Override
        public void run() {
            for (long i = 0; i < time; i++) {
                ds.change(a);
            }

            ds.print();
        }
    }

    static class DoSomething {
        public long a = 0;

        public void change(long change) {
            a += change;
        }

        public void print() {
            System.out.println(a);
        }
    }
}
