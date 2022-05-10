package Base.Arr;

import java.util.Scanner;

public class MultiArr {
    public static void main(String[] args) {
        String[] names = new String[6];

        names[0] = "语文";
        names[1] = "数学";
        names[2] = "英语";
        names[3] = "物理";
        names[4] = "化学";
        names[5] = "生物";

        Scanner s = new Scanner(System.in);
        System.out.println("请输入需要记录几年的成绩");
        int year = s.nextInt();

        double[][] scores = new double[year][6];

        for (int i = 0; i < year; i++) {
            for (int j = 0; j < 6; j++) {
                scores[i][j] = 80 + Math.random() * 20;
            }
        }

        while (true) {
            System.out.println("请输入要进行的操作编号");
            System.out.println("1:求某年最好成绩\n2:求某年的平均成绩\n3:求所有年份最好成绩\n4:求某门课历年最好成绩\n");

            int number = s.nextInt();

            int inputYear = 0;
            int subject = 0;

            switch (number) {
                case 1 -> {
                    System.out.println("请输入年份");
                    inputYear = s.nextInt();
                    int bestScore = 0;
                    for (int i = 0; i < 6; i++) {
                        if (scores[inputYear][i] > scores[inputYear][bestScore]) {
                            bestScore = i;
                        }
                    }
                    System.out.println(inputYear + "年的最好成绩科目是:" + names[bestScore] + "，得分是" + scores[inputYear][bestScore]);
                }
                case 2 -> {
                    System.out.println("请输入年份");
                    inputYear = s.nextInt();
                    double total = 0;
                    for (int i = 0; i < 6; i++) {
                        total += scores[number][i];
                    }
                    System.out.println(number + "年的平均成绩是:" + total / 6);
                }
                case 3 -> {
                    int maxYear = 0;
                    int maxSubject = 0;
                    for (int i = 0; i < year; i++) {
                        for (int j = 0; j < 6; j++) {
                            if (scores[i][j] > scores[maxYear][maxSubject]) {
                                maxYear = i;
                                maxSubject = j;
                            }
                        }
                    }
                    System.out.println("最好成绩是第" + maxYear + "年的" + names[maxSubject]);
                }
                case 4 -> {
                    System.out.println("请输入年份");
                    subject = s.nextInt();
                    int subjectYear = 0;
                    for (int i = 0; i < year; i++) {
                        if (scores[i][subject] > scores[subjectYear][subject]) {
                            subjectYear = i;
                        }
                    }
                    System.out.println(names[subject] + "的最好成绩是" + subjectYear + "年的" + scores[subjectYear][subject]);
                }
            }
        }
    }
}
