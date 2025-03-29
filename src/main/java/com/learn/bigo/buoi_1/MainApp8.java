package com.learn.bigo.buoi_1;

import java.util.*;

public class MainApp8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String t = scanner.nextLine();

        List<String> sList = Arrays.asList(s.split(""));
        List<String> tList = Arrays.asList(t.split(""));

        if (isSub(s, t)) {
            System.out.println("automaton");
            return;
        }

        if (isArray(sList, tList)) {
            System.out.println("array");
            return;
        }

        if (isNeedTree(sList, tList)) {
            System.out.println("need tree");
            return;
        }

        System.out.println("both");

    }

    private static boolean isNeedTree(List<String> sList, List<String> tList) {
        for (String s : tList) {
            if (!sList.contains(s)) {
                return true;
            }
        }

        Map<String, Integer> mapS =  new HashMap<>();
        Map<String, Integer> mapT =  new HashMap<>();
        for (String item : sList) {
            mapS.put(item, mapS.getOrDefault(item, 0) + 1);
        }
        for (String item : tList) {
            mapT.put(item, mapT.getOrDefault(item, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : mapT.entrySet()) {
            if (!mapS.containsKey(entry.getKey()) || mapS.get(entry.getKey()) < entry.getValue()) {
                return true;
            }
        }


        return false;
    }

    private static boolean isSub(String s, String t) {
        if (s.contains(t)) {
            return true;
        }

        char[] tArray = t.toCharArray();
        char[] sArray = s.toCharArray();
        int i = 0;
        int j;
        for (j = 0; j < tArray.length;) {
            if (i >= sArray.length) {
                break;
            }
            if (tArray[j] == sArray[i]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == tArray.length;
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


//bvoczualgnsktwmfivbztaovhjmdjqkpyuhlyaigrpzhfnemepaqkhijjaybjjzwsxgjmsdohysjbxqzkjgntinitk
//voczualgsktwmfivbztaovhjmdjqkpyuhlyaigrpzhfnemepaqkhijjaybjjzwsxgjmsdohysjbxqzkjgntinitk
// automation

//didddnqycavfkewzywcfuevmckfcltlpsxviljqbhbgperbzitjslgxsxqnkmsenbrmvoatqrnpyrzpg
//naeashxiekmvckyksmnjbbpyaltcqqzwsjvyraernzofwspnvgdeub
// need tree
}
