package com.learn.bigo.buoi_7.setup;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] A = new int[n];

        String line = sc.nextLine();
        String[] arr = line.split(" ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(arr[i]);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> top3 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            minHeap.offer(A[i]);

            if (minHeap.size() > 3) {
                minHeap.poll();
            }

            if (i < 2) {
                System.out.println("-1");
            } else {
                top3.clear();
                top3.addAll(minHeap);
                long product = 1;
                for (int num : top3) {
                    product *= num;
                }
                System.out.println(product);
            }
        }
    }
}
