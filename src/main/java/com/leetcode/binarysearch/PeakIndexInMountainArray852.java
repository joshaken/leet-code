package com.leetcode.binarysearch;

public class PeakIndexInMountainArray852 {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 3) {
            return 1;
        }
        int left = 1;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
