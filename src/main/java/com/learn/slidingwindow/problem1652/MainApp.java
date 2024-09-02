package com.learn.slidingwindow.problem1652;

import java.util.Arrays;

//Title: 1652. Defuse the Bomb
//Link: https://leetcode.com/problems/defuse-the-bomb/description/
public class MainApp {
    public static int[] decrypt(int[] code, int k) {
        System.out.println(Arrays.toString(code));
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decrypt(new int[]{5, 7, 1, 4}, 3))); // [12,10,16,13]
        System.out.println(Arrays.toString(decrypt(new int[]{1, 2, 3, 4}, 0))); // [0,0,0,0]
        System.out.println(Arrays.toString(decrypt(new int[]{2, 4, 9, 3}, -2))); // [12,5,6,13]
    }
}
