package Base;

public class SparseArr {
    public static void main(String[] args) {
        int[][] arr1 = new int[11][11];
        arr1[1][2] = 1;
        arr1[2][3] = 2;

        for (int[] ints : arr1) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        System.out.println("=============");

        int sum = 0;
        for (int[] ints : arr1) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }

        int[][] arr2 = new int[sum + 1][3];

        int num = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (i == 0) {
                    arr2[i][0] = arr1.length;
                    arr2[i][1] = arr1[i].length;
                    arr2[i][2] = sum;
                }

                if (arr1[i][j] != 0) {
                    num++;
                    arr2[num][0] = i;
                    arr2[num][1] = j;
                    arr2[num][2] = arr1[i][j];
                }
            }
        }

        for (int[] a : arr2) {
            for (int b : a) {
                System.out.print(b + "\t");
            }

            System.out.println();
        }

        System.out.println("===============");

        int[][] arr3 = new int[arr2[0][0]][arr2[0][1]];

        for (int i = 1; i < arr2.length; i++) {
            arr3[arr2[i][0]][arr2[i][1]] = arr2[i][2];
        }

        for (int[] a : arr3) {
            for (int b : a) {
                System.out.print(b + "\t");
            }

            System.out.println();
        }
    }
}
