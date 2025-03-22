package com.learn.bigo.buoi_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MainApp_Buoi4_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (true) {
            int n = Integer.parseInt(scanner.nextLine());
            if (n == 0) {
                break;
            }
            lines.add(scanner.nextLine());
        }

        for (String line : lines) {
            String[] array = line.split(" ");
            System.out.println(valid(array, array.length));
        }

    }

    private static String valid(String[] array, int n) {
        Stack<Integer> stack = new Stack<>();
        boolean ans = false;
        int nextExpected = 1;
        for (int i = 0; i < array.length; i++) {
            int x = Integer.parseInt(array[i]);
            if (x == nextExpected) {
                nextExpected++;
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() == nextExpected) {
                        stack.pop();
                        nextExpected++;
                    } else {
                        break;
                    }
                }
                if (nextExpected < n) {
                    stack.push(x);
                }
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == nextExpected) {
                stack.pop();
                nextExpected++;
            } else {
                break;
            }
        }

        if (stack.isEmpty()) {
            ans = true;
        }

        return ans ? "yes" : "no";

    }


}
