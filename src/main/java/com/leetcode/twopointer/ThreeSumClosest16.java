package com.leetcode.twopointer;

import java.util.Arrays;

public class ThreeSumClosest16 {
    public static void main(String[] args) {
        int[] ints = {-1, 2, 1, -4};
        threeSumClosest(ints, 1);
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(closest - target) > Math.abs(sum - target)) {

                    closest = sum;
                }
                if (sum - target > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return closest;
    }
}
