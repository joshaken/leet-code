package com.leetcode.binarysearch;

public class FindFirstAndLastPosition34 {

    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int[] ints = new int[2];


            ints[0] = findBorder(nums, target, true);
            ints[1] = findBorder(nums, target, false);
            return ints;

        }

        private int findBorder(int[] nums, int target, boolean leftBorder) {

            int left = 0;
            int right = nums.length - 1;
            int border = -1;
            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    border = mid;

                    if (leftBorder) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] > target) {
                    right = mid - 1;

                } else {
                    left = mid + 1;
                }

            }

            return border;
        }
    }
}
