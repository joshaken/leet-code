package com.leetcode.binarysearch;

public class FindPeakElement162 {
    class Solution {
        /**
         * Why + 1 for only left?
         * Because middle + 1 is greater than middle. That means middle is definitely not one of peaks.
         * Just in case for right pointer, middle is greater than middle + 1, that means there is a possibility that middle is one of peaks.
         * <p>
         * That's why we move right to middle and move left to middle + 1.
         */
        public int findPeakElement(int[] nums) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] > nums[mid + 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            }


            return left;
        }
    }
}
