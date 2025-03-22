package com.learn.bigo.buoi_4;

import java.util.Scanner;
import java.util.Stack;

public class MainApp_Buoi4_1 {
    //    (a+(b*c))
//((a+b)*(z+x))
//((a+t)*((b+(a+c))^(c+d)))
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] listExpression = new String[n];
        for (int i = 0; i < n; i++) {
            listExpression[i] = scanner.nextLine();
        }

        for (String expression : listExpression) {
            System.out.println(toRPN(expression));
        }

    }

    private static String toRPN(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isNumberOrLetter(chars[i])) {
                builder.append(chars[i]);
            }

            if (isOperator(chars[i])) {
                stack.push(chars[i]);
            }

            if ('(' == chars[i]) {
                stack.push('(');
                continue;
            }

            if (')' == chars[i]) {
                while (!stack.isEmpty()) {
                    if ('(' == stack.peek()) {
                        stack.pop();
                        break;
                    } else {
                        builder.append(stack.pop());
                    }
                }
            }
        }

        return builder.toString();
    }

    private static boolean isNumberOrLetter(char c) {
        return Character.isLetterOrDigit(c);
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
}
