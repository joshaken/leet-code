package com.leetcode.binarysearch;

public class ValidPerfectSquare367 {
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return true;
            }

            int left = 0;
            int right = num / 2;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                long result = (long) mid * mid;
                if (result == num) {
                    return true;
                } else if (result < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}
