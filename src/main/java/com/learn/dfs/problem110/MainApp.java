package com.learn.dfs.problem110;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Title: 110. Balanced Binary Tree
//Link: https://leetcode.com/problems/balanced-binary-tree/?envType=problem-list-v2&envId=depth-first-search
public class MainApp {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static String convertToUtcTimestamp(String dateTimeStr, String sourceTimezone) {
        try {
            String pattern = dateTimeStr.contains("-HH:") ?
                    "yyyy-MM-dd-HH:mm:ss" : "yyyy-MM-dd HH:mm:ss";

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, formatter);

            // Get timezone - use provided one or system default
            ZoneId zoneId = (sourceTimezone != null && !sourceTimezone.isEmpty()) ?
                    ZoneId.of(sourceTimezone) : ZoneId.systemDefault();

            // Apply timezone and convert to UTC instant
            ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

            // Return UTC timestamp in seconds (not milliseconds)
            return String.valueOf(zonedDateTime.toInstant().getEpochSecond());
        } catch (Exception e) {
            return "";
        }
    }

    public static String convertTimestampToDateString(String timestamp, String format) {
        // Default format if none provided
        String dateFormat = (format != null && !format.isEmpty())
                ? format
                : "yyyy-MM-dd HH:mm:ss";

        // Convert timestamp to Instant
        Instant instant = Instant.ofEpochMilli(Long.parseLong(timestamp));

        // Convert to LocalDateTime using UTC (to avoid timezone adjustments)
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

        // Format the date using the specified pattern
        return dateTime.format(DateTimeFormatter.ofPattern(dateFormat));
    }

    public static void main(String[] args) {

        System.out.println(convertToUtcTimestamp("2025-02-25 16:57:30", null));
        System.out.println(convertTimestampToDateString("1740477450000", null));

        TreeNode node1 = new TreeNode(2, null, null);
        TreeNode node2 = new TreeNode(3, null, null);
        TreeNode tree1 = new TreeNode(1, node1, node2);
        TreeNode tree2 = new TreeNode(1, node1, node2);
        TreeNode tree3 = new TreeNode(1, node2, node1);

        System.out.println(isBalanced(tree1));
        System.out.println(isBalanced(tree2));
        System.out.println(isBalanced(tree3));



    }

    private static boolean isBalanced = true;

    public static boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = 1 + dfs(root.left);
        int r = 1 + dfs(root.right);

        if (Math.abs(r-l) > 1) {
            isBalanced = false;
        }

        List<String> lefts = new ArrayList<>();
        List<String> rights = new ArrayList<>();


        new ArrayList<>(Arrays.asList(lefts, rights));

        return Math.max(l, r);
    }

}
