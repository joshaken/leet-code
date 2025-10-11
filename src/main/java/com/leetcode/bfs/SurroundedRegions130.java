package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SurroundedRegions130 {
    public static void main(String[] args) {

    }

    public static void solve(char[][] board) {


    }

    public static void bfs(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        ArrayDeque<Integer[]> queue = new ArrayDeque<>();

        //先处理四周的值
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.addLast(new Integer[]{i, 0});
                board[i][0] = '#';
            }
            if (board[i][n - 1] == 'O') {
                queue.addLast(new Integer[]{i, n - 1});
                board[i][n - 1] = '#';
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                queue.addLast(new Integer[]{0, j});
                board[0][j] = '#';
            }
            if (board[m - 1][j] == 'O') {
                queue.addLast(new Integer[]{m - 1, j});
                board[m - 1][j] = '#';
            }
        }
        //再处理所有和边界相链接的值
        while (!queue.isEmpty()) {
            Integer[] rig = queue.pollFirst();

            Integer row = rig[0];
            Integer colum = rig[1];

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = colum + dir[1];

                if (nr < m && nr >= 0 && nc < n && nc >= 0 && board[nr][nc] == 'O') {
                    board[nr][nc] = '#';
                    queue.addLast(new Integer[]{nr, nc});
                }
            }
        }
        //处理所有剩余的「O」
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
