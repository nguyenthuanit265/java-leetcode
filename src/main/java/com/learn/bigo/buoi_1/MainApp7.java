package com.learn.bigo.buoi_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApp7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int k = Integer.parseInt(firstLine.split(" ")[1]);
        Map<Integer, Integer> mapLength = new HashMap<>();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
            if (mapLength.containsKey(arr[i].length())) {
                mapLength.put(arr[i].length(), mapLength.get(arr[i].length()) + 1);
            } else {
                mapLength.put(arr[i].length(), 1);
            }
        }

        int bestCase, worstCase;
        String correctPass = scanner.nextLine();
        int delay = 5;
        int count = 0;
        int countNotPass = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].length() < correctPass.length()) {
                count++;
            }

            if (!arr[i].equals(correctPass) && arr[i].length() <= correctPass.length()) {
                countNotPass++;
            }
        }
        if (count == 0) {
            bestCase = 1;
        } else {
            bestCase = (count / k) * delay + count + 1; // cong 1 khi nhap pass dung
        }

        worstCase = (countNotPass / k) * delay + countNotPass + 1; // cong 1 khi nhap pass dung

        System.out.printf("\n%s %s%n", bestCase, worstCase);

    }
}
