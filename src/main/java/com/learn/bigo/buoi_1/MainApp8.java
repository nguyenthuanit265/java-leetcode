package com.learn.bigo.buoi_1;

import java.util.*;

public class MainApp8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String t = scanner.nextLine();

        List<String> sList = Arrays.asList(s.split(""));
        List<String> tList = Arrays.asList(t.split(""));

        if (isNeedTree(sList, tList)) {
            System.out.println("need tree");
            return;
        }

        if (isSub(s, t)) {
            System.out.println("automaton");
            return;
        }

        if (isArray(sList, tList)) {
            System.out.println("array");
            return;
        }

        System.out.println("both");

    }

    private static boolean isNeedTree(List<String> sList, List<String> tList) {
        for (String item : tList) {
            if (!sList.contains(item)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isSub(String s, String t) {
        return s.contains(t);
    }

    private static boolean isArray(List<String> sList, List<String> tList) {
        if (sList.size() != tList.size()) {
            return false;
        }
        Map<String, Integer> mapS =  new HashMap<>();
        Map<String, Integer> mapT =  new HashMap<>();
        for (String item : sList) {
            mapS.put(item, mapS.getOrDefault(item, 0) + 1);
        }
        for (String item : tList) {
            mapT.put(item, mapT.getOrDefault(item, 0) + 1);
        }
        return mapS.equals(mapT);
    }
}
