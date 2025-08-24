package com.learn.leetcode75.problem605;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        List<Integer> index1 = new ArrayList<>();
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                index1.add(i);
            }
        }
        System.out.println(index1);
        if (index1.size() == 0) {
            int res = (flowerbed.length - 1)/2;
            return n <= res;
        }
        int i = 0, j = 1;
        int res = 0;
        while (j < index1.size()) {
            int space = index1.get(j) - index1.get(i) - 1;
            res += (space - 1) / 2;
            i++;
            j++;
        }

        return n <= res;
    }

    public static void main(String[] args) {
        int[] flower = new int[]{0,0,0,0,0};
        System.out.println(canPlaceFlowers(flower, 2));
    }
}
