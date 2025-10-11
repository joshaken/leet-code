package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class RottingOranges994 {
    public static void main(String[] args) {
        int[][] g = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        orangesRotting(g);
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == n && m == 1 && grid[0][0] == 0) {
            return 0;
        }
        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
        int freshOrange = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.addLast(new Integer[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }
        if (freshOrange == 0) {
            return 0;
        } else if (queue.isEmpty()) {
            return -1;
        }

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        int minutes = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer[] num = queue.removeFirst();
                Integer row = num[0];
                Integer line = num[1];

                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nl = line + dir[1];

                    if (nr < m && nr >= 0 && nl < n && nl >= 0 && grid[nr][nl] == 1) {
                        grid[nr][nl] = 2;
                        freshOrange--;
                        queue.addLast(new Integer[]{nr, nl});
                    }
                }
            }
            minutes++;
        }

        if (freshOrange == 0) {
            return minutes;
        }
        return -1;
    }
}
