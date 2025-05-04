package com.learn.bigo.buoi_7.setup;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MainApp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.startsWith("1")) {
                priorityQueue.add(Integer.valueOf(line.split(" ")[1]));
            }

            if (line.startsWith("2")) {
                priorityQueue.remove(Integer.valueOf(line.split(" ")[1]));
            }

            if (line.startsWith("3")) {
                ans.add(priorityQueue.peek());
            }
        }

        for (Integer item : ans) {
            System.out.println(item);
        }
    }
}
