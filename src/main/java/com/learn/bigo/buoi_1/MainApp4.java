package com.learn.bigo.buoi_1;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp4 {
/* TC1
 abaa
 acaa
 answer: abab */

    public static void main(String[] args) {
        vitalyAndString();
    }

    private static void vitalyAndString() {
        Scanner scanner = new Scanner(System.in);
//        char ch = 'a';
//        int ascii = (int) ch;
//        System.out.println("The ASCII value of " + ch + " is: " + (int)ch);

        String lineS = scanner.nextLine();
        String lineT = scanner.nextLine();

        StringBuilder ans = new StringBuilder();
        char[] sArr = lineS.toCharArray();
        char[] tArr = lineT.toCharArray();
        int i = sArr.length - 1;
        while (i >= 0) {
            if (sArr[i] == 'z') {
                sArr[i] = 'a';
                i--;
            } else {
                sArr[i] = (char) ((int) sArr[i] + 1);
                break;
            }
        }

        for (int j = 0; j < sArr.length; j++) {
            if (tArr[j] > sArr[j]) {
                System.out.println(String.copyValueOf(sArr));
                return;
            } else if (tArr[j] < sArr[j]) {
                System.out.println("No such string");
                return;
            } else {
                ans.append(sArr[j]);
            }
        }

        if (ans.toString().equals(lineT)) {
            System.out.println("No such string");
            return;
        }

        System.out.println(ans);
    }
}
