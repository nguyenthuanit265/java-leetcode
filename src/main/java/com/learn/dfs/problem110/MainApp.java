package com.learn.dfs.problem110;

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

    public static void main(String[] args) {
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

        return Math.max(l, r);
    }

}
