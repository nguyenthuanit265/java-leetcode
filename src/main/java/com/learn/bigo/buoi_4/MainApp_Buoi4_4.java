package com.learn.bigo.buoi_4;

import java.util.*;

public class MainApp_Buoi4_4 {
    /*
    *
    7
    19
    10
    6
    0
    Discarded cards: 1, 3, 5, 7, 4, 2
    Remaining card: 6
    Discarded cards: 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 4, 8, 12, 16, 2, 10, 18, 14
    Remaining card: 6
    Discarded cards: 1, 3, 5, 7, 9, 2, 6, 10, 8
    Remaining card: 4
    Discarded cards: 1, 3, 5, 2, 6
    Remaining card: 4
    *
    *
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> lines = new ArrayList<>();
        while (true) {
            int n = Integer.parseInt(scanner.nextLine());
            if (n == 0) {
                break;
            }
            lines.add(n);
        }

        for (int n : lines) {
            show(n);
        }
    }

    public static void show(int n) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder deleted = new StringBuilder();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        while (queue.size() > 1) {
            deleted.append(queue.poll()).append(", ");
            queue.add(queue.poll());
            found = true;
        }
        if (found) {
            System.out.println("Discarded cards: " + deleted.deleteCharAt(deleted.length() - 1).deleteCharAt(deleted.length() - 1));
        } else {
            System.out.println("Discarded cards:");
        }
        System.out.println(String.format("Remaining card: %s", queue.peek()));

    }


}
