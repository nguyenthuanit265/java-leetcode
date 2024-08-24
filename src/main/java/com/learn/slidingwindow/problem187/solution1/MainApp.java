package com.learn.slidingwindow.problem187.solution1;

import java.util.*;

//Title: 187. Repeated DNA Sequences
//Link: https://leetcode.com/problems/repeated-dna-sequences/description/
public class MainApp {

    /*
    * DNA là gì:

    DNA (Deoxyribonucleic acid) là một chuỗi các nucleotide.
    Trong bài toán này, DNA được biểu diễn bằng một chuỗi ký tự.
    Mỗi nucleotide được biểu diễn bằng một trong bốn chữ cái: 'A', 'C', 'G', hoặc 'T'.
    Ví dụ: "ACGAATTCCG" là một chuỗi DNA hợp lệ.


    Yêu cầu của bài toán:

    Bạn được cung cấp một chuỗi s đại diện cho một chuỗi DNA.
    Nhiệm vụ của bạn là tìm tất cả các chuỗi con có độ dài 10 ký tự xuất hiện nhiều hơn một lần trong chuỗi DNA này.


    Đầu vào:

    Một chuỗi s đại diện cho chuỗi DNA.


    Đầu ra:

    Một danh sách các chuỗi con có độ dài 10 ký tự thỏa mãn yêu cầu.
    Các chuỗi con này phải xuất hiện ít nhất hai lần trong chuỗi DNA gốc.
    Thứ tự của các chuỗi con trong kết quả không quan trọng.


    Ví dụ:

    Nếu có một chuỗi DNA "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
    Các chuỗi con 10 ký tự xuất hiện nhiều hơn một lần là "AAAAACCCCC" và "CCCCCAAAAA".
    *
    * */

    public static List<String> findRepeatedDnaSequences(String s) {
        int windowSize = 10;
        if (s.length() < windowSize) {
            return Collections.emptyList();
        }
        Map<String, Integer> map = new HashMap<>();
        Set<String> ans = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        String[] sArr = s.split("");
        for (int i = 0; i < windowSize; i++) {
            builder.append(sArr[i]);
        }
        map.put(builder.toString(), 1);

        for (int i = windowSize; i < sArr.length; i++) {
            builder.append(sArr[i]);
            builder.deleteCharAt(0);
            if (map.containsKey(builder.toString())) {
                ans.add(builder.toString());
            } else {
                map.put(builder.toString(), 1);
            }
        }

        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        System.out.println(findRepeatedDnaSequences("A"));
    }
}
