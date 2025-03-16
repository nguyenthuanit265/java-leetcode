package com.learn.bigo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp_Buoi2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int k = Integer.parseInt(firstLine.split(" ")[1]);
        if (k == 1 && n >= k) {
            System.out.println("0");
        } else if (n < k) {
            System.out.println("-1 -1");
        }

        String[] array = secondLine.split(" ");
        String ans = "";
        HashSet<String> result = Arrays.stream(array)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        if (result.size() < k) {
            System.out.println("-1 -1");
        }

        System.out.println("-1 -1");
    }


}
