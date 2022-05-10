package Base.Arr;

import java.util.Arrays;

public class Arr {
    public static void main(String[] args) {
        int[] arr1 = {123, 435634, 234, 1, 67, 312, 756756};

        System.out.println(Arrays.toString(bubbling(arr1)));
    }

    // 冒泡排序
    public static int[] bubbling(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
