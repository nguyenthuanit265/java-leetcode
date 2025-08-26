package com.learn.leetcode75.problem605;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                return n <= 1;
            } else {
                if (n > 0) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        List<Integer> index1 = new ArrayList<>();
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                index1.add(i);
            }
        }
        if (index1.size() == 0) {
            int res = 0;
            if ((flowerbed.length) % 2 == 0) {
                res = (flowerbed.length) / 2;
            } else {
                res = (flowerbed.length) / 2;
                res += 1;
            }

            return n <= res;
        }
        int i = 0, j = 1;
        int res = 0;
        int size = index1.size();

        if (index1.get(0) != 0) {
            int space = index1.get(0);
            res += (space) / 2;
            i = 1;
            j = i + 1;
        }

        while (j < size) {
            int space = index1.get(j) - index1.get(i) - 1;
            res += (space - 1) / 2;
            i++;
            j++;
        }

        if (index1.get(index1.size() - 1) < flowerbed.length - 1) {
            int space = flowerbed.length - (index1.get(index1.size() - 1) + 1);
            res += space / 2;
        }

        return n <= res;
    }


public static void main(String[] args) {
    int[] flower = new int[]{1, 0, 0, 0, 1};
    System.out.println(canPlaceFlowers(flower, 1));

    int[] flower2 = new int[]{1, 0, 0, 0, 1, 0, 0};
    System.out.println(canPlaceFlowers(flower2, 2));
}
}
