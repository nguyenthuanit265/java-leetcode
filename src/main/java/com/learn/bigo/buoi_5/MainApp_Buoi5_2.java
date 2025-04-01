package com.learn.bigo.buoi_5;

import java.util.*;

public class MainApp_Buoi5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            ans.add(meet(sc));
        }

        for (Integer an : ans) {
            System.out.println(an);
        }
    }

    private static int meet(Scanner sc) {
        int n = Integer.parseInt(sc.nextLine().trim());
        int e = Integer.parseInt(sc.nextLine().trim());

        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int componentsCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                componentsCount++;
                dfs(i, graph, visited);
            }
        }

        return componentsCount;
    }

    private static void dfs(int start, List<ArrayList<Integer>> graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    stack.push(v);
                }
            }
        }
    }
}
