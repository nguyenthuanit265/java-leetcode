package com.learn.bigo.buoi_9;

import java.util.*;

public class MainApp_Buoi9_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        int[] ans = new int[testCases];
        for (int t = 0; t < testCases; t++) {
            String line = scanner.nextLine();
            int n = Integer.parseInt(line.split(" ")[0]);
            int m = Integer.parseInt(line.split(" ")[1]);

            int[] priorities = new int[n];
            String linePri = scanner.nextLine();
            String[] list = linePri.split(" ");
            for (int i = 0; i < list.length; i++) {
                priorities[i] = Integer.parseInt(list[i]);
            }
            ans[t] = calculatePrintTime(priorities, m);
        }

        for (int item : ans) {
            System.out.println(item);
        }

        scanner.close();
    }

    public static int calculatePrintTime(int[] priorities, int myPosition) {
        Queue<Integer> positions = new LinkedList<>();
        List<Integer> priorityList = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            positions.add(i);
            priorityList.add(priorities[i]);
        }

        int time = 0;

        while (!positions.isEmpty()) {
            int currentPosition = positions.poll();
            int currentPriority = priorityList.get(0);
            priorityList.remove(0);
            boolean hasHigherPriority = false;
            for (int priority : priorityList) {
                if (priority > currentPriority) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                positions.add(currentPosition);
                priorityList.add(currentPriority);
            } else {
                time++;

                if (currentPosition == myPosition) {
                    return time;
                }
            }
        }

        return -1;
    }

}