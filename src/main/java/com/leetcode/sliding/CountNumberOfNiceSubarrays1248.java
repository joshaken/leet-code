package com.leetcode.sliding;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays1248 {
    public static void main(String[] args) {
        int[] nu = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int i = numberOfSubarrays(nu, 2);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 前缀奇数个数 = 0 出现过一次
        int count = 0;
        int odd = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                odd++;
            }
            //每到一个位置，计算当前 odd 值
            //
            //想要 odd[r] - odd[l-1] = k
            // 等价于 odd[l-1] = odd[r] - k
            // 看看有没有之前的前缀，满足 odd - k
            count += map.getOrDefault(odd - k, 0);
            map.put(odd, map.getOrDefault(odd, 0) + 1);
        }
        return count;

    }

    public static int numberOfSubarrays1(int[] nums, int k) {
        return fn(nums, k) - fn(nums, k - 1);
    }

    private static int fn(int[] nums, int k) {
        int left = 0;
        int odd = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) {
                odd++;
            }

            while (odd > k) {
                if (nums[left] % 2 == 1) {
                    odd--;
                }
                left++;
            }

            count = count + (right - left) + 1;
        }
        return count;
    }
}
