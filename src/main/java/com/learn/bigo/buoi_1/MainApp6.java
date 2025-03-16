package com.learn.bigo.buoi_1;

import java.util.*;

public class MainApp6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLine = Integer.parseInt(scanner.nextLine());
        int i = 1;
        Map<String, Integer> map = new HashMap<>();
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        while (i <= numLine) {
            String line = scanner.nextLine();
            map.put(line, i);

            if (Integer.parseInt(line.split(" ")[0]) < l) {
                l = Integer.parseInt(line.split(" ")[0]);
            }

            if (Integer.parseInt(line.split(" ")[1]) > r) {
                r = Integer.parseInt(line.split(" ")[1]);
            }

            i++;
        }

        if (map.containsKey(String.format("%s %s", l, r))) {
            System.out.println(map.get(String.format("%s %s", l, r)));
            return;
        }

        System.out.println(-1);

    }
}
