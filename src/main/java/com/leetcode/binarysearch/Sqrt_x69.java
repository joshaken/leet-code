package com.leetcode.binarysearch;

public class Sqrt_x69 {

    class Solution {
        public int mySqrt(int x) {

            if (x < 2) {
                return x;
            }
            int left = 0;
            int right = x / 2;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                //避免大数值 字符越界
                long result = (long) mid * mid;
                if (result == x) {
                    return mid;
                } else if (result < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //因为是向下取整，所以使用right
            return right;
        }
    }
}
