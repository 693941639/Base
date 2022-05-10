package Base;

public class Demo1 {
    public static void main(String[] args) {
        int a = add(1, 2);

        int b = add(1, 2, 3);

        int c = add(1, 2, 5);

        int d = add(1, 2, 3);

        System.out.println(
                a + ", " + b + ", " + c
        );

        System.out.println(d + ", " + a);
    }

    public static int add (int a, int b) {
        return a + b;
    }

    public static int add (int a, int b, int c) {
        return a + b + c;
    }

}
