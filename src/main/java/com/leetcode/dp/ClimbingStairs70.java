package com.leetcode.dp;

public class ClimbingStairs70 {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }

        int pre1 = 3;
        int pre2 = 2;
        int cur = 0;
        for (int i = 3; i < n; i++) {
            cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;

        }
        return cur;
    }

    public int climbStairs2(int n) {

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
