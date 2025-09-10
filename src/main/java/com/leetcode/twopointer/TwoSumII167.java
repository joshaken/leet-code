package com.leetcode.twopointer;

public class TwoSumII167 {
    public static void main(String[] args) {
        int[] ints = {2, 3, 4};
        twoSum(ints, 6);
    }


    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }

        }
        return new int[0];
    }

    public static int[] twoSum1(int[] numbers, int target) {
        int[] ints = new int[2];
        int out = 0;
        for (; out < numbers.length; out++) {
            int t = target - numbers[out];

            int left = out + 1;
            int right = numbers.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] == t) {
                    ints[0] = out + 1;
                    ints[1] = mid + 1;
                    return ints;
                } else if (numbers[mid] > t) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return ints;
    }
}
