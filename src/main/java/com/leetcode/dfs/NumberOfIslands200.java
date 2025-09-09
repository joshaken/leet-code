package com.leetcode.dfs;

import java.util.ArrayDeque;

//所有上下左右相连的1算作是一个岛屿
public class NumberOfIslands200 {
    public int numIslands1(char[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        return bfs(grid);

    }

    int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int bfs(char[][] grid) {

        int count = 0;
        ArrayDeque<Integer[]> stack = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;

                    stack.push(new Integer[]{i, j});

                    while (!stack.isEmpty()) {
                        Integer[] pop = stack.pop();
                        Integer r = pop[0];
                        Integer l = pop[1];

                        grid[r][l] = '0';

                        for (int[] direct : directs) {
                            int nr = r + direct[0];
                            int nl = l + direct[1];

                            if (nr >= 0 && nl >= 0
                                    && nr < grid.length && nl < grid[0].length
                                    && grid[nr][nl] == '1') {
                                stack.push(new Integer[]{nr, nl});
                            }

                        }
                    }
                }

            }
        }

        return count;
    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid[0] == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    //沉岛
                    dfs(grid, i, j);
                }

            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] == '#'
                || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '#';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }


}
