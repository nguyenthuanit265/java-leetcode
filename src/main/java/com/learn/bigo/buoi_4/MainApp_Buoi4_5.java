package com.learn.bigo.buoi_4;

import java.util.*;

public class MainApp_Buoi4_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        show(scanner.nextLine());
    }

    public static void show(String formula) {
        Stack<String> stack = new Stack<>();
        char[] args = formula.toCharArray();
        int total = 0;
        for (char c : args) {
            if ('(' == c) {
                stack.push("(");
            }
            if (isAtom(c)) {
                stack.push(String.valueOf(valueOf(c)));
            }
            if (isNumber(c)) {
                int number = Integer.parseInt(stack.pop()) * Integer.parseInt(String.valueOf(c));
                stack.push(String.valueOf(number));
            }

            if (')' == c) {
                int sum = 0;
                while (!stack.isEmpty()) {
                    if ("(".equals(stack.peek())) {
                        stack.pop();
                        break;
                    } else {
                        sum += Integer.parseInt(stack.pop());
                    }
                }
                stack.push(String.valueOf(sum));
            }
        }

        while (!stack.isEmpty()) {
            total += Integer.parseInt(stack.pop());
        }

        System.out.println(total);

    }

    private static int valueOf(char atom) {
        int C = 12, H = 1, O = 16;
        if (atom == 'C') {
            return C;
        } else if (atom == 'H') {
            return H;
        } else if (atom == 'O') {
            return O;
        }
        return 0;
    }

    private static boolean isAtom(char c) {
        return Character.isLetter(c);
    }

    private static boolean isNumber(char c) {
        return Character.isDigit(c);
    }
}
