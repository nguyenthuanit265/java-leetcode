package com.learn.bigo.buoi_4;

import java.util.*;

public class MainApp_Buoi4_8 {

    public static void main(String[] args) {

//        System.out.println(show("<<><>>>>>"));
//        System.out.println(show("><<<<"));
//        System.out.println(show("><<>>>>>>>"));
//        System.out.println(show("<<<><>"));
//        System.out.println(show(">>>"));
//        System.out.println(show("<<><<>><<"));
//        System.out.println(show("<>"));
//        System.out.println(show("<"));
//        System.out.println(show(">"));
//        System.out.println(show("><>><"));


        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLine();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(longestValid(array[i]));
        }

    }

    static class Symbol {
        Character character;
        int index;

        public Symbol(Character character, int index) {
            this.character = character;
            this.index = index;
        }
    }
    public static int longestValid(String symbol) {
        char[] chars = symbol.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int maxValidLength = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '<') {
                // Nếu gặp "<", đẩy vị trí của nó vào stack
                stack.push(i);
            } else if (chars[i] == '>') {
                // Nếu gặp ">" và stack không rỗng, có nghĩa là có một "<" tương ứng
                if (!stack.isEmpty()) {
                    stack.pop();

                    // Nếu stack rỗng, toàn bộ chuỗi từ đầu đến vị trí hiện tại là hợp lệ
                    // Ngược lại, chuỗi từ phần tử trên cùng của stack đến vị trí hiện tại là hợp lệ
                    if (stack.isEmpty()) {
                        maxValidLength = i + 1;
                    }
                } else {
                    // Nếu gặp ">" mà không có "<" tương ứng, dừng việc xử lý
                    break;
                }
            }
        }

        return maxValidLength;
    }

}
