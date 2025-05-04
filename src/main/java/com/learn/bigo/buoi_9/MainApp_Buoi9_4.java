package com.learn.bigo.buoi_9;

import java.util.*;

public class MainApp_Buoi9_4 {
    static class Point {
        int row, col, dist;

        Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        String siteIdInput = "YORK HOTEL";
        List<String> siteIdsList = Arrays.asList(siteIdInput.split(";"));
        System.out.println("----------------------00q0q0q00qq");
        System.out.println(siteIdsList);


        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            int R = Integer.parseInt(line.split(" ")[0]);
            int C = Integer.parseInt(line.split(" ")[1]);

            if (R == 0 && C == 0) break;

            boolean[][] map = new boolean[R][C];
            Arrays.stream(map).forEach(row -> Arrays.fill(row, false));

            String lineRows = scanner.nextLine();
            int rows = Integer.parseInt(lineRows.split(" ")[0]);
            for (int i = 0; i < rows; i++) {
                String lineTemp = scanner.nextLine();
                String[] parts = lineTemp.split(" ");
                int row = Integer.parseInt(parts[0]);
                int bombs = Integer.parseInt(parts[1]);
                for (int j = 0; j < bombs; j++) {
                    int col = Integer.parseInt(parts[2 + j]);
                    map[row][col] = true;
                }
            }

            String lineStart = scanner.nextLine();
            String lineEnd = scanner.nextLine();
            int startRow = Integer.parseInt(lineStart.split(" ")[0]);
            int startCol = Integer.parseInt(lineStart.split(" ")[1]);
            int endRow = Integer.parseInt(lineEnd.split(" ")[0]);
            int endCol = Integer.parseInt(lineEnd.split(" ")[1]);

            int shortestTime = findShortestPath(map, startRow, startCol, endRow, endCol, R, C);
            System.out.println(shortestTime);
        }

        scanner.close();
    }

    private static int findShortestPath(boolean[][] map, int startRow, int startCol, int endRow, int endCol, int R, int C) {
        // 4 hướng di chuyển: lên, xuống, trái, phải
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        boolean[][] visited = new boolean[R][C];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startRow, startCol, 0));
        visited[startRow][startCol] = true;

        // BFS
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.row == endRow && current.col == endCol) {
                return current.dist;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = current.row + dr[i];
                int newCol = current.col + dc[i];

                if (isValid(newRow, newCol, R, C) && !visited[newRow][newCol] && !map[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.add(new Point(newRow, newCol, current.dist + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int row, int col, int R, int C) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }
}
