package com.learn.bigo.buoi_5;

import java.util.*;

public class MainApp_Buoi5_6 {
    private static final int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dc = {1, 0, -1, -1, 1, 0, -1, 1};

    private static final String expression = "ALLIZZWELL";
    private static boolean isFound;
    private static boolean[][] visited;
    private static char[][] matrix;
    private static int r, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            // Reset flag for each test case
            isFound = false;

            // Read dimensions
            r = scanner.nextInt();
            c = scanner.nextInt();

            // Initialize matrix and visited array
            matrix = new char[r][c];
            visited = new boolean[r][c];

            // Read matrix
            for (int i = 0; i < r; i++) {
                String line = scanner.next();
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }

            // Try starting the search from each cell with 'A'
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (matrix[i][j] == 'A' && !isFound) {
                        dfs(i, j, 1); // Start with position 1 (second character)
                    }
                }
            }

            // Print result
            System.out.println(isFound ? "YES" : "NO");
        }

        scanner.close();
    }

    private static void dfs(int i, int j, int pos) {
        if (pos == expression.length()) {
            isFound = true;
            return;
        }

        visited[i][j] = true;

        for (int k = 0; k < 8; k++) {
            int u = i + dr[k];
            int v = j + dc[k];

            if (isValid(u, v) && !visited[u][v] && matrix[u][v] == expression.charAt(pos)) {
                dfs(u, v, pos + 1);
                if (isFound) return;
            }
        }

        visited[i][j] = false;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}