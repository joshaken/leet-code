package com.leetcode.dp;

public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        int[] ints = {1, 5, 11, 5};
        canPartition(ints);
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        //不停使用目标值去减数组中的值
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

}
