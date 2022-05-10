package Base;

import Base.Thread.Volatile;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Volatile v = new Volatile();
        Thread t1 = new Thread(() -> {
            while (true) {
                v.add();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                v.compare();
            }
        });

        t2.start();
    }
}
