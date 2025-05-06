package com.learn.problemlist.problem242;

import java.util.*;
import java.util.stream.Collectors;

//242. Valid Anagram
//https://leetcode.com/problems/valid-anagram
public class MainApp {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<String, Integer> mapS = new HashMap<>();
        String[] stringS = s.split("");
        for (String item : stringS) {
            if (mapS.containsKey(item)) {
                mapS.put(item, mapS.get(item) + 1);
            } else {
                mapS.put(item, 1);
            }
        }

        String[] stringT = t.split("");
        for (String item : stringT) {
            if (mapS.containsKey(item)) {
                int count = mapS.get(item);
                if (count > 0) {
                    count--;
                    if (count == 0) {
                        mapS.remove(item);
                    } else {
                        mapS.put(item, count);
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }


        return mapS.isEmpty();
    }
}
