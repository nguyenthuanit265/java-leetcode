package com.learn.bigo.buoi_1;

import java.util.Scanner;

public class MainApp3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] excitingTimes = new int[n];
        for (int i = 0; i < n; i++) {
            excitingTimes[i] = scanner.nextInt();
        }

        int result = calculateWatchingTime(excitingTimes, n);
        System.out.println(result);
    }

    private static int calculateWatchingTime(int[] excitingTimes, int n) {
        if (n == 0) {
            return 15;
        }

        if (excitingTimes[0] > 15) {
            return 15;
        }

        int lastExcitingMinute = excitingTimes[0];

        for (int i = 1; i < n; i++) {
            if (excitingTimes[i] - lastExcitingMinute > 15) {
                return lastExcitingMinute + 15;
            }
            lastExcitingMinute = excitingTimes[i];
        }

        return Math.min(lastExcitingMinute + 15, 90);
    }
}
