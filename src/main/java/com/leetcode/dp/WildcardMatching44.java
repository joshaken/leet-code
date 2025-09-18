package com.leetcode.dp;

public class WildcardMatching44 {
    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        isMatch(s, p);
    }
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int i = n - 1; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                dp[m][i] = dp[m][i + 1];
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i][j] = dp[i + 1][j + 1];
                } else if (p.charAt(j) == '*') {
                    boolean pick = dp[i + 1][j];
                    boolean nopic = dp[i][j + 1];
                    dp[i][j] = pick || nopic;
                } else {
                    dp[i][j] = false;
                }


            }
        }


        return dp[0][0];
    }
}
