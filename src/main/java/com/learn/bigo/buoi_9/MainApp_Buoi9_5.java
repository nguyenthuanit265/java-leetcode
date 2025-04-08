package com.learn.bigo.buoi_9;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp_Buoi9_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        String line = scanner.nextLine();
        String[] arr = line.split(" ");
        for (int i = 0; i < arr.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(array);
        int median = array[n / 2];
        System.out.println(median);
        scanner.close();
    }

}