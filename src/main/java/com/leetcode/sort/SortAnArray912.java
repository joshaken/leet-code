package com.leetcode.sort;

public class SortAnArray912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[left + (right - left) / 2];

        int i = left;
        int j = right;
        while (i <= j) {
            // 从左找比 pivot 大的
            while (arr[i] < pivot) {
                i++;
            }
            // 从右找比 pivot 小的
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(arr, left, j);
        quickSort(arr, i, right);
    }
}
