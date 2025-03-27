package com.learn.bigo.buoi_5;

import java.util.*;

public class MainApp_Buoi5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String line = sc.nextLine().strip();
            int u = Integer.parseInt(line.split(" ")[0]);
            int v = Integer.parseInt(line.split(" ")[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int country = queue.poll();

            for (int neighbor : graph.get(country)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distances[neighbor] = distances[country] + 1;
                    queue.add(neighbor);
                }
            }
        }

        int q = Integer.parseInt(sc.nextLine().strip());
        int minDistance = Integer.MAX_VALUE;
        int bestCountry = -1;
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(sc.nextLine());
            if (distances[x] < minDistance || (distances[x] == minDistance && x < bestCountry)) {
                minDistance = distances[x];
                bestCountry = x;
            }
        }

        System.out.println(bestCountry);
    }
}

//6
//1 2
//1 3
//1 4
//2 5
//2 6
//4
//5
//6
//3
//4

//-----
//9
//1 6
//6 9
//1 2
//1 3
//2 4
//4 7
//3 5
//5 8
//3
//7
//8
//9