package com.learn.bigo.buoi_1;

import java.util.Scanner;

public class MainApp1 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());
            String jackets = scanner.nextLine();
            if (n == 1) {
                if (1 == Integer.parseInt(jackets)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                return;
            }

            String jacketsFormat = jackets.replace(" ", "").replace("1", "");
            if (jacketsFormat.length() == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } catch (Exception e) {
            System.out.println("NO");
        }
    }
}
