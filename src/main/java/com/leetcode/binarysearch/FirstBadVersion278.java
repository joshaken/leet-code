package com.leetcode.binarysearch;

public class FirstBadVersion278 {
    //    public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;
        int bad = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                bad = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return bad;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
//    }
}
