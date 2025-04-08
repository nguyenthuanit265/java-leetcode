package com.learn.bigo.buoi_9;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainApp_Buoi9_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int k = Integer.parseInt(line.split(" ")[0]);
        int n = Integer.parseInt(line.split(" ")[1]);
        int w = Integer.parseInt(line.split(" ")[2]);
        long totalCost = (long) k * w * (w + 1) / 2;
        long borrow = Math.max(0, totalCost - n);
        System.out.println(borrow);
    }

}