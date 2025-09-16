package com.leetcode.dp;

public class HouseRobberII213 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 1, 1};
        rob(ints);
    }
    public  static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        return Math.max(getMax(nums, 0, n - 2), getMax(nums, 1, n - 1));
    }

    private static int getMax(int[] nums, int start, int end) {
        int maxRob = 0;
        int preRob = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(maxRob, nums[i] + preRob);
            preRob = maxRob;
            maxRob = temp;
        }

        return maxRob;
    }
}
