package com.leetcode.dp;

import java.util.HashMap;

public class DeleteAndEarn740 {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxNum = -1;
        int[] numLookup = new int[10010];
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            numLookup[num] = numLookup[num] + num;
        }
        int[] dp = new int[maxNum + 1];
        dp[0] = numLookup[0];
        dp[1] = numLookup[1];

        for (int i = 2; i <= maxNum; i++) {
            dp[i] = Math.max(numLookup[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[maxNum];
    }
    public int deleteAndEarn1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] dp = new int[maxNum + 1];
        dp[0] = 0 * 0;
        dp[1] = 1 * map.getOrDefault(1, 0);
        for (int i = 2; i <= maxNum; i++) {
            int sum = i * map.getOrDefault(i, 0);
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum);
        }
        return dp[maxNum];

    }
}
