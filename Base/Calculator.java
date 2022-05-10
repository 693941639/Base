package Base;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String action = "start";
        Scanner s = new Scanner(System.in);
        do {
            System.out.print("输入需要进行的运算: ");
            String operation = s.next();
            System.out.println("输入第一个数");
            int a = s.nextInt();
            System.out.println("输入第二个数");
            int b = s.nextInt();

            switch (operation) {
                case "+" -> System.out.println(a + b);
                case "-" -> System.out.println(a - b);
                case "*" -> System.out.println(a * b);
                case "/" -> System.out.println(a / b);
            }

            System.out.print("还要继续运算吗？");
            action = s.next();
        } while (!action.equals("exit"));
    }


}
