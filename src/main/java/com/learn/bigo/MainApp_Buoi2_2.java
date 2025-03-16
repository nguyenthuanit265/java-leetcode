package com.learn.bigo;

import java.util.*;
import java.util.stream.Collectors;

public class MainApp_Buoi2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        String thirdLine = scanner.nextLine();

        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int m = Integer.parseInt(firstLine.split(" ")[1]);
        String[] a = secondLine.split(" ");
        String[] b = thirdLine.split(" ");
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (Integer.parseInt(b[j]) >= Integer.parseInt(a[i])) {
                i++;
            }
            j++;
        }

        System.out.println(n-i);
    }


}
