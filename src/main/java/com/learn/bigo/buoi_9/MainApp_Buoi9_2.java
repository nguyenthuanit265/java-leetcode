package com.learn.bigo.buoi_9;

import java.util.*;

public class MainApp_Buoi9_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        System.out.println(checkPangram(s) ? "YES" : "NO");
    }

    public static boolean checkPangram(String s) {
        s = s.toLowerCase();
        Set<Character> letters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                letters.add(c);
            }
        }
        return letters.size() == 26;
    }

}