package com.learn.leetcode75.problem1071;

public class MainApp {
    public static String gcdOfStrings(String str1, String str2) {
        if (!isValid(str1, str2)) {
            return "";
        }

        if (str1.length() == str2.length()) {
            return str1;
        }
        int i = 0, j = 0, run = 1;
        String res = "";
        String str = str1.length() > str2.length() ? str1 : str2;
        while (j + run < str.length()) {
            String temp1 = str.substring(0, i + run);

            j = i + run;
            String temp2 = str.substring(j, j + run);
            if (temp1.equals(temp2)) {
                if (res.length() == 0) {
                    res = temp1;
                } else {
                    if (temp1.length() > res.length() && str1.length() % temp1.length() == 0 && str2.length() % temp1.length() == 0) {
                        res = temp1;
                    }
                }
                run++;
            } else {
                run++;
            }
        }


        return res;
    }

    public static boolean isValid(String str1, String str2) {
        return (str1 + str2).equals(str2 + str1);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("FFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKST", "FFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKSTFFBNXKST"));
    }
}
