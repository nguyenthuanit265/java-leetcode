package com.learn.bigo.buoi_1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApp8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String t = scanner.nextLine();

        List<String> sList = Arrays.asList(s.split(""));
        List<String> tList = Arrays.asList(t.split(""));

        for (String item : tList) {
            if (!sList.contains(item)) {
                System.out.println("need tree");
                return;
            }
        }
        if (sList.size() == tList.size()) {
            System.out.println("array");
        } else {
            if (isSub(s, t)) {
                System.out.println("automaton");
            } else {
                System.out.println("both");
            }
        }

    }

    private static boolean isSub(String t, String s) {
        int j = 0;
        for (int i = 0; i < s.length() && j < t.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        return j == t.length();
    }
}
