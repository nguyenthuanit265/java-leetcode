package com.learn.leetcode75.problem1071;

public class MainApp {
    public static String gcdOfStrings(String str1, String str2) {
        if (!isValid(str1, str2)) {
            return "";
        }

        String str = str1.length() > str2.length() ? str2 : str1;
        int len = str.length();
        int i = 1;
        while (i <= len) {
            String temp = str.substring(0, i);
//            if () {
//
//            }
        }


        return "";
    }

    public static boolean isValid(String str1, String str2) {
        return (str1 + str2).equals(str2 + str1);
    }

    public static void main(String[] args) {
        String temo = "012345";
        System.out.println(temo.substring(0, 1));
    }
}
