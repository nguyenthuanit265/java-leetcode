package com.learn.aquariux;

public class MainApp {
    public static boolean validate(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }

        if (username.length() < 4) {
            return false;
        }

        if (!Character.isLetter(username.charAt(0))) {
            return false;
        }

        if (username.charAt(username.length() - 1) == '_') {
            return false;
        }

        int underScore = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }

            if (c == '_') {
                underScore++;
            }
        }

        if (underScore > 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate("Mike_Standish")); // Valid username
        System.out.println(validate("Mike Standish")); // Invalid username
    }
}
