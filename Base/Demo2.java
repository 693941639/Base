package Base;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static void printMax (double... i) {
        if (i.length == 0) {
            System.out.println("No args");
        }

        double result = 0;

        for (double v : i) {
            if (result < v) {
                result = v;
            }
        }

        System.out.println(result);
    }

    public static int factorial (int a) {
        if (a < 1) {
            return 0;
        }

        if (a == 1) {
            return 1;
        } else {
            return a * factorial(a - 1);
        }
    }
}
