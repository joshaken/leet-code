package com.leetcode.binarysearch;

public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
        int[] num1 = new int[]{3, 1};
        search(num1, 1);
    }

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } else if (nums[mid] > nums[left]) {

                if (nums[mid] > target && nums[left] < target) {
                    right = mid - 1;
                } else if (nums[mid] > target && nums[left] > target) {
                    left = mid + 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //中间有旋转，
                if (nums[mid] < target && nums[right] > target) {
                    left = mid + 1;
                } else if (nums[mid] < target && nums[right] < target) {
                    right = mid - 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }
}
