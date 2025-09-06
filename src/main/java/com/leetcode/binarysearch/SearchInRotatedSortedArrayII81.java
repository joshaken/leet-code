package com.leetcode.binarysearch;

public class SearchInRotatedSortedArrayII81 {
    public static void main(String[] args) {
        int[] ints = {2,2,2,0,0,1};
        boolean search = search(ints, 0);
    }

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target || nums[left] == target || nums[right] == target) {
                return true;
            } else if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left = left + 1;
                right = right - 1;
            } else if (nums[mid] >= nums[left]) {
                if (nums[mid] > target && nums[left] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

}
