package com.learn.twopointers.problem141.solution1;

import java.util.HashMap;
import java.util.Map;

//Title: 141. Linked List Cycle
//Link: https://leetcode.com/problems/linked-list-cycle/description/
public class MainApp {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static boolean hasCycle(ListNode head) {
        Map<Object, Boolean> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }

            map.put(head, true);
            head = head.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(hasCycle(node1));
    }
}
