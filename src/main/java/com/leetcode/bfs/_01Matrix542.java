package com.leetcode.bfs;

import java.util.ArrayDeque;

public class _01Matrix542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.addLast(new Integer[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer[] num = queue.removeFirst();
            Integer row = num[0];
            Integer line = num[1];

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nl = line + dir[1];

                if (nr < m && nr >= 0 && nl < n && nl >= 0 && mat[nr][nl] == -1) {
                    mat[nr][nl] = mat[row][line] + 1;
                    queue.addLast(new Integer[]{nr, nl});
                }
            }
        }

        return mat;
    }
}
