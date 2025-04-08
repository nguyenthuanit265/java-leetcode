package com.learn.bfs.problem1971;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        System.out.println(n);
        System.out.println(Arrays.deepToString(edges));
        System.out.println(source);
        System.out.println(destination);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) return true;
            for (int neighborhood : graph.get(current)) {
                if (!visited[neighborhood]) {
                    visited[neighborhood] = true;
                    queue.add(neighborhood);
                }
            }
        }


        return false;
    }
}
