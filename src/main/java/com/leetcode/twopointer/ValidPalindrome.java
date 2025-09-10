package com.leetcode.twopointer;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String x = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = x.length() - 1;
        while (left < right) {
            if (x.charAt(left) != x.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isPalindrome1(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            if (!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }
            char r = s.charAt(right);
            if (!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }
            left++;
            right--;
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }
        }

        return true;
    }
}
