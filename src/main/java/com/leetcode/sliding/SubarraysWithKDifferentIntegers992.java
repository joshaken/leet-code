package com.leetcode.sliding;

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers992 {
    public static void main(String[] args) {
        int[] nu = {1, 2, 1, 2, 3};
        subarraysWithKDistinct(nu, 2);
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {

        return fn(nums, k) - fn(nums, k - 1);
    }

    private static int fn(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int n = nums.length;
        HashMap<Integer, Integer> exist = new HashMap<>();
        while (right < n) {
            exist.put(nums[right], exist.getOrDefault(nums[right], 0) + 1);

            while (exist.keySet().size() > k) {
                //shrink windows
                exist.put(nums[left], exist.get(nums[left]) - 1);

                if (exist.get(nums[left]) == 0) {
                    exist.remove(nums[left]);
                }
                left++;
            }

            count = count + (right - left) + 1;
            right++;

        }
        return count;
    }
}
