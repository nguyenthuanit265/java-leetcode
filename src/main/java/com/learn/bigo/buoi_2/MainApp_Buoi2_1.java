package com.learn.bigo.buoi_2;

import java.util.*;

public class MainApp_Buoi2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int k = Integer.parseInt(firstLine.split(" ")[1]);
        if (k == 1 && n >= k) {
            System.out.println("0");
        } else if (n < k) {
            System.out.println("-1 -1");
        }

        String[] array = secondLine.split(" ");
        String ans = "";
        int indexStart = 0;
        int indexEnd = 0;
        String charStart = array[indexStart];
        while (indexStart < n - 1 && charStart.equals(array[indexStart + 1])) {
            indexStart++;
        }

        int count = 1;
        Set<String> visited = new HashSet<>();
        visited.add(array[indexStart]);
        for (int i = indexStart + 1; i < n; i++) {
            if (!visited.contains(array[i])) {
                count++;
            }
            visited.add(array[i]);

            if (count == k) {
                indexEnd = i;
                break;
            }
        }

        if (count==k) {
            System.out.println(String.format("%s %s", indexStart + 1, indexEnd + 1));
        } else {
            System.out.println("-1 -1");
        }
    }


}


//2 5 6 5 2 1 7 9 7 2 5 5 2 4