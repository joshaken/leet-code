package com.leetcode.twopointer;

public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {

        int max = 0;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int l = height[left];
            int r = height[right];
            int h = Math.min(l, r);
            max = Math.max(max, h * (right - left));

            if (l < r) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
