package com.learn.leetcode75.problem392;

public class MainApp {
    public static boolean isSubsequence(String s, String t) {
        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();
        int index2 = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sA.length; i++) {
            char charCheck = sA[i];
            while (index2 < tA.length) {
                if (charCheck == tA[index2]) {
                    builder.append(tA[index2++]);
                    break;
                }
                index2++;
            }
        }

        return builder.toString().length() == sA.length;
    }

    public static void main(String[] args) {
//        System.out.println(isSubsequence("abc", "ahbgdc"));
//        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
    }
}
