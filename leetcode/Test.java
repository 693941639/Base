package leetcode;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();

        System.out.println(t.longestPalindrome("ac"));
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        int arrLength = chars.length;

        int maxLength = 0;
        String maxStr = "";

        for (int i = 0; i < arrLength; i++) {
            if (i == 0 && chars[0] == chars[1] && maxLength < 2) {
                maxLength = 2;
                maxStr = s.substring(0, 2);
                continue;
            }

            if (i == arrLength - 1 && chars[arrLength - 1] == chars[arrLength - 2] && maxLength < 2) {
                maxLength = 2;
                maxStr = s.substring(arrLength - 2, arrLength);
                continue;
            }

            int j = 1;

            while (i - j >= 0 && i + j <= arrLength - 1 && chars[i - j] == chars[i + j]) {
                if (2 * j + 1 > maxLength) {
                    maxLength = 2 * j + 1;
                    maxStr = s.substring(i - j, i + j + 1);
                }

                j++;
            }

            j = 0;

            while (i - j >= 0 && i + j + 1 <= arrLength - 1 && chars[i - j] == chars[i + j + 1]) {
                if (2 * j + 2 > maxLength) {
                    maxLength = 2 * j + 2;
                    maxStr = s.substring(i - j, i + j + 2);
                }

                j++;
            }
        }

        if (maxLength == 0) {
            maxStr = s.substring(0, 1);
        }

        return maxStr;
    }
}
