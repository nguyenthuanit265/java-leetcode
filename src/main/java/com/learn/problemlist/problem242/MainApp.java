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
        Map<Character, Integer> mapS = new HashMap<>();
        for (char item : s.toCharArray()) {
            mapS.put(item, mapS.getOrDefault(item, 0) + 1);
        }

        for (char item : t.toCharArray()) {
            if (!mapS.containsKey(item)) {
                return false;
            }

            mapS.put(item, mapS.get(item) - 1);
            if (mapS.get(item) == 0) mapS.remove(item);
        }
        return mapS.isEmpty();
    }
}
