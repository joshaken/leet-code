package com.leetcode.dp;

public class LongestCommonSubsequence1143 {
    public int longestCommonSubsequence(String text1, String text2) {

        int[] dp = new int[text1.length()];
        int max = 0;
        for (char c : text2.toCharArray()) {
            int cur = 0;
            for (int i = 0; i < dp.length; i++) {
                if (cur < dp[i]) {
                    cur = dp[i];
                } else if (c == text1.charAt(i)) {
                    dp[i] = cur + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;

    }
}
