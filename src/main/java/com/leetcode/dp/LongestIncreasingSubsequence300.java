package com.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] ints = {10, 9, 2, 5, 3, 7, 101, 18};
        lengthOfLIS(ints);

    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        ArrayList<Integer> list = new ArrayList<>();

        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (list.get(list.size() - 1) >= nums[i]) {
                int index = binarySearchIndex(list, nums[i]);
                list.set(index, nums[i]);
            } else {
                list.add(nums[i]);
            }
        }


        return list.size();


    }

    private static int binarySearchIndex(ArrayList<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == num) {
                return mid;
            } else if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int lengthOfLIS1(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        dp[0] = 1;
        dp[1] = nums[0] < nums[1] ? 2 : 1;
        int maxSub = Math.max(dp[0], dp[1]);

        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxSub = Math.max(maxSub, dp[i]);
        }

        return maxSub;
    }
}
