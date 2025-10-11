package com.leetcode.bfs;

import java.util.ArrayDeque;

public class MaxAreaOfIsland695 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        bfs(grid);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max;
        max = bfs(grid);
        return max;
    }

    private static int dfs(int[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    int count = dfsHelper(grid, i, j);

                    max = Math.max(max, count);
                }
            }
        }


        return max;
    }

    private static int dfsHelper(int[][] grid, int row, int line) {
        if (row >= grid.length || row < 0
                || line >= grid[0].length || line < 0 || grid[row][line] != 1) {
            return 0;
        }

        grid[row][line] = 0;
        int count = 1;
        count += dfsHelper(grid, row - 1, line);
        count += dfsHelper(grid, row + 1, line);
        count += dfsHelper(grid, row, line - 1);
        count += dfsHelper(grid, row, line + 1);
        return count;

    }

    private static int bfs(int[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.addLast(new Integer[]{i, j});

                    int count = 0;
                    while (!queue.isEmpty()) {

                        Integer[] island = queue.pollFirst();
                        count++;
                        Integer row = island[0];
                        Integer line = island[1];
                        grid[row][line] = 0;

                        for (int[] dir : directions) {
                            int nr = row + dir[0];
                            int nl = line + dir[1];

                            if (nr < grid.length && nr >= 0
                                    && nl < grid[0].length && nl >= 0
                                    && grid[nr][nl] == 1) {
                                grid[nr][nl] = 0;
                                queue.addLast(new Integer[]{nr, nl});
                            }
                        }
                    }

                    max = Math.max(count, max);
                }
            }
        }

        return max;
    }
}
