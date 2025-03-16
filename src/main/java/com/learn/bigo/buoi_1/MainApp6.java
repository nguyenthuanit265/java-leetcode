package com.learn.bigo.buoi_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String third = scanner.nextLine();
        String fourth = scanner.nextLine();

        int nA = Integer.parseInt(first.split(" ")[0]);
        int nB = Integer.parseInt(first.split(" ")[1]);
        int k = Integer.parseInt(second.split(" ")[0]);
        int m = Integer.parseInt(second.split(" ")[1]);
        List<Integer> a = new ArrayList<>();
        for (String s : third.split(" ")) {
            a.add(Integer.valueOf(s));
        }

        List<Integer> b = new ArrayList<>();
        for (String s : fourth.split(" ")) {
            b.add(Integer.valueOf(s));
        }

        List<Integer> newA = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (i + 1 <= k) {
                newA.add(a.get(i));
            }
        }

        List<Integer> newB = new ArrayList<>();
        int countM = 0;
        for (int i = b.size() - 1; i >= 0; i--) {
            if (countM + 1 <= m) {
                newB.add(b.get(i));
                countM++;
            }
        }

        System.out.println(newA);
        System.out.println(newB);
        for (Integer item : newA) {
            if (item >= newB.get(newB.size() - 1)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
