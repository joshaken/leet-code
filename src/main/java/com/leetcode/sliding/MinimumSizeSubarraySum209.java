package com.leetcode.sliding;

public class MinimumSizeSubarraySum209 {
    public int minSubArrayLen1(int target, int[] nums) {

        int left = 0;
        int minLen = 0;
        long sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            if (sum >= target) {
                if (minLen == 0) {
                    minLen = right - left + 1;
                }

                long temp = sum;
                while (temp >= target) {
                    temp = temp - nums[left];
                    if (temp >= target) {
                        sum = sum - nums[left];
                        left++;
                    }
                }

                minLen = Math.min(minLen, right - left + 1);

            }
        }

        return minLen;
    }

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum = sum - nums[left];
                left++;

            }

        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }
    }

}
