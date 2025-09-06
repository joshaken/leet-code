package com.leetcode.binarysearch;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] ints = {
                {-10, -8}, {-6, -5}, {-2, -2}, {-1, 0}, {3, 4}, {7, 7}, {8, 9}, {10, 10}, {11, 11}, {12, 14}, {15, 16}, {17, 19}, {20, 21}, {22, 22}, {25, 27}, {28, 30}, {32, 32}, {35, 36}
        };
        int[][] ints1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        boolean b = searchMatrix(ints1, 3);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int left = 0;
        int right = row - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target || matrix[left][0] == target || matrix[right][0] == target) {
                return true;
            } else if (matrix[right][0] < target) {
                return innerBinarySearch(matrix[right], target);
            } else if (matrix[mid][0] < target && target < matrix[right][0]) {
                if (right - mid <= 1) {
                    return innerBinarySearch(matrix[mid], target);
                }
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    private static boolean innerBinarySearch(int[] arr, int target) {
        int left = 1;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
