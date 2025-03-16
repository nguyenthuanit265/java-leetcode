package com.learn.bigo.buoi_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApp2 {
    public static void main(String[] args) {
        Map<String, Integer> letterMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char letter = (char) ('a' + i);
            letterMap.put(String.valueOf(letter), i);
        }
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int ans = 0;
        String[] words = str.split("");

        String first = words[0];
        if (Math.abs(letterMap.get("a") - letterMap.get(first)) > Math.abs(Math.abs(letterMap.get("a") - letterMap.get(first)) - letterMap.size())) {
            ans += Math.abs(Math.abs(letterMap.get("a") - letterMap.get(first)) - letterMap.size());
        } else {
            ans += Math.abs(letterMap.get("a") - letterMap.get(first));
        }
        
        
        for (int i = 0; i < words.length - 1; i++) {
            String fromWord = words[i];
            String toWord = words[i + 1];
            if (Math.abs(letterMap.get(fromWord) - letterMap.get(toWord)) > Math.abs(Math.abs(letterMap.get(fromWord) - letterMap.get(toWord)) - letterMap.size())) {
                ans += Math.abs(Math.abs(letterMap.get(fromWord) - letterMap.get(toWord)) - letterMap.size());
            } else {
                ans += Math.abs(letterMap.get(fromWord) - letterMap.get(toWord));
            }
        }

        System.out.println(ans);
    }
}
