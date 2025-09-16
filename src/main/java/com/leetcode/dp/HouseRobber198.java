package com.leetcode.dp;

public class HouseRobber198 {
    //Consider nums = [2, 7, 9, 3, 1]:
    //
    //dp[0] = 2: Robbing the first house.
    //dp[1] = 7: Robbing the second house since it has more money.
    //dp[2] = max(7, 9 + 2) = 11: Robbing the first and third houses.
    //dp[3] = max(11, 3 + 7) = 11: Skipping the fourth house.
    //dp[4] = max(11, 1 + 11) = 12: Robbing the first, third, and fifth houses.
    //Output: 12
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
}
