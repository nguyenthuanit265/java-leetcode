package com.learn.bigo;

import java.util.Scanner;

public class MainApp_Buoi2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int t = Integer.parseInt(firstLine.split(" ")[1]);
        String[] array = secondLine.split(" ");
        int ans = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (left < n && right < n) {
            sum += Integer.parseInt(array[right]);
            while (sum > t) {
                sum -= Integer.parseInt(array[left]);
                left++;
            }

            if (right - left + 1. > ans) {
                ans = right - left + 1;
            }

            right++;
        }
        System.out.println(ans);

    }


}
