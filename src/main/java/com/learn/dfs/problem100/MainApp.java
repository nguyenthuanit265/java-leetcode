package com.learn.dfs.problem100;

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

        System.out.println(isSameTree(tree1, tree2));
        System.out.println(isSameTree(tree1, tree3));
    }

    private static StringBuffer valTree1 = new StringBuffer();
    private static StringBuffer valTree2 = new StringBuffer();

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, valTree1);
        dfs(q, valTree2);

        System.out.println(valTree1);
        System.out.println(valTree2);

        return valTree1.toString().contentEquals(valTree2);
    }

    public static void dfs(TreeNode node, StringBuffer valTree) {
        if (node == null) {
            valTree.append("null");
            return;
        }
        valTree.append(node.val);
        dfs(node.left, valTree);
        dfs(node.right, valTree);
    }
}
