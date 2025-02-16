package com.learn.string.problem8;

//Title: 8. String to Integer (atoi)
//Link: https://leetcode.com/problems/string-to-integer-atoi/description/?envType=problem-list-v2&envId=string
public class MainApp {
    public static void main(String[] args) {
        System.out.println(Character.getNumericValue('A'));
        System.out.println(Character.getNumericValue('Z'));
        System.out.println(Character.getNumericValue('a'));
        System.out.println(Character.getNumericValue('z'));
        System.out.println(Character.getNumericValue('0'));
        System.out.println(Character.getNumericValue('9'));
        System.out.println(Integer.MIN_VALUE);

        System.out.println(myAtoi("   42     "));
        System.out.println(myAtoi("   4a2     "));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("-042"));
        System.out.println(myAtoi("0-1"));
        System.out.println(myAtoi("-0"));
        System.out.println(myAtoi("+-12"));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi(".1"));
        System.out.println(myAtoi("020000000000000000000"));
        System.out.println(myAtoi("   -042"));
        System.out.println(myAtoi("010"));
    }

    public static boolean isWhitespace(String s) {
        return " ".equals(s);
    }

    public static boolean isSignNegative(String s) {
        return "-".equals(s);
    }

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        StringBuilder ans = new StringBuilder();
        String[] sArr;
        try {
            sArr = s.strip().split("");
        } catch (Exception e) {
            return 0;
        }
        boolean isNegative = false;
        boolean isProcess = false;
        for (int i = 0; i < sArr.length; i++) {
            if (!isNumber(sArr[i])) {
                if (isProcess) {
                    break;
                } else {
                    if (isWhitespace(sArr[i])) {
                        continue;
                    } else if (isSignNegative(sArr[i])) {
                        isNegative = true;
                        isProcess = true;
                        continue;
                    } else if ("+".equals(sArr[i])) {
                        isProcess = true;
                        continue;
                    } else {
                        break;
                    }
                }
            } else {
                if (!"0".equals(sArr[i])) {
                    ans.append(sArr[i]);
                } else {
                    if (!ans.isEmpty() && (ans.toString().charAt(0) > 0)) {
                        ans.append(sArr[i]);
                    }
                }
            }

            isProcess = true;
        }

        if (ans.isEmpty()) {
            return 0;
        }
        if (isNegative) {
            if (ans.length() > String.valueOf(Integer.MIN_VALUE).length()) {
                return Integer.MIN_VALUE;
            }
        } else {
            if (ans.length() > String.valueOf(Integer.MAX_VALUE).length()) {
                return Integer.MAX_VALUE;
            }
        }

        long val = isNegative ? Long.valueOf("-" + ans) : Long.valueOf(ans.toString());
        if (val > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (val < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return isNegative ? Integer.parseInt(String.valueOf("-" + ans)) : Integer.parseInt(String.valueOf(ans));
    }
}
