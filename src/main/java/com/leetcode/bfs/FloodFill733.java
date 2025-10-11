package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FloodFill733 {
    public static void main(String[] args) {
//        int[][] ints = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] ints = {{0, 0, 0}, {1, 0, 0}};
        bfs(ints, 1, 0, 2);
    }


    public static int[][] dfs(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            dfsHelper(image, sr, sc, color, image[sr][sc]);
        }
        return image;
    }

    public static void dfsHelper(int[][] image, int row, int line, int color, int target) {
        if (row >= image.length || row < 0 || line >= image[0].length || line < 0
                || image[row][line] != target) {
            return;
        }
        image[row][line] = color;

        dfsHelper(image, row, line - 1, color, target);
        dfsHelper(image, row - 1, line, color, target);
        dfsHelper(image, row + 1, line, color, target);
        dfsHelper(image, row, line + 1, color, target);

    }

    public static int[][] bfs(int[][] image, int sr, int sc, int color) {

        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
        int m = image.length;
        int n = image[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        queue.addLast(new Integer[]{sr, sc});
        int or = image[sr][sc];
        ArrayList<Integer[]> change = new ArrayList<>(m * n);
        while (!queue.isEmpty()) {
            Integer[] tar = queue.pollFirst();
            Integer row = tar[0];
            Integer line = tar[1];


            image[row][line] = -1;
            change.add(new Integer[]{row, line});
            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nl = line + dir[1];

                if (nr < m && nr >= 0 && nl < n && nl >= 0
                        && image[nr][nl] == or) {
                    image[nr][nl] = -1;
                    queue.addLast(new Integer[]{nr, nl});
                }
            }

        }

        for (Integer[] arr : change) {
            image[arr[0]][arr[1]] = color;
        }
        return image;
    }
}
