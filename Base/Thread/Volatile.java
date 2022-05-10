package Base.Thread;

public class Volatile {
    volatile int a, b, c, d, f, g;
    volatile long e;

    public void add() {
        a+=1;
        b+=1;
        c+=1;
        d+=1;

        e+=1;

        f+=1;
        g+=1;
    }

    public void compare() {
        if (g > e) {
            System.out.println("Yes");
        }
    }
}
