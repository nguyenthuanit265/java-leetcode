package com.learn.leetcode75.problem443;

public class MainApp {

    public int compress(char[] chars) {
        int read = 0, write = 0;
        int n = chars.length;
        while (read < n) {
            char currentChar = chars[read];
            int start = read;
            while (read < n && chars[read] == currentChar) {
                read++;
            }

            chars[write++] = currentChar;
            int count = read - start;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;
    }

    public static void main(String[] args) {

    }
}
