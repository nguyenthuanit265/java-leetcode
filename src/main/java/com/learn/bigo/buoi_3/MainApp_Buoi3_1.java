package com.learn.bigo.buoi_3;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp_Buoi3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int x = Integer.parseInt(firstLine.split(" ")[1]);

        String[] programs = secondLine.split(" ");
        int[] intArray = new int[programs.length];

        for (int i = 0; i < programs.length; i++) {
            intArray[i] = Integer.parseInt(programs[i]);
        }
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));
        int ans = 0;
        for (int i = 0; i < intArray.length; i++) {
            ans += x * intArray[i];
            if (x > 1) {
                x -= 1;
            }
        }

        System.out.println(ans);

    }


}
